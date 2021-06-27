package com.kalessil.phpStorm.phpInspectionsEA.inspectors.apiUsage;

import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.jetbrains.php.lang.psi.elements.ConstantReference;
import com.jetbrains.php.lang.psi.elements.FunctionReference;
import com.kalessil.phpStorm.phpInspectionsEA.fixers.UseSuggestedReplacementFixer;
import com.kalessil.phpStorm.phpInspectionsEA.openApi.BasePhpElementVisitor;
import com.kalessil.phpStorm.phpInspectionsEA.openApi.BasePhpInspection;
import com.kalessil.phpStorm.phpInspectionsEA.openApi.PhpLanguageLevel;
import com.kalessil.phpStorm.phpInspectionsEA.options.OptionsComponent;
import com.kalessil.phpStorm.phpInspectionsEA.utils.MessagesPresentationUtil;
import com.kalessil.phpStorm.phpInspectionsEA.utils.OpenapiTypesUtil;
import com.kalessil.phpStorm.phpInspectionsEA.utils.PossibleValuesDiscoveryUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * This file is part of the Php Inspections (EA Extended) package.
 *
 * (c) Vladimir Reznichenko <kalessil@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

public class JsonEncodingApiUsageInspector extends BasePhpInspection {
    // Inspection options.
    public boolean HARDEN_DECODING_RESULT_TYPE = true;
    public boolean DECODE_AS_ARRAY             = false;
    public boolean DECODE_AS_OBJECT            = true;
    public boolean HARDEN_ERRORS_HANDLING      = true;

    private static final String messageResultType     = "Please specify the second argument (clarifies decoding into array or object).";
    private static final String messageErrorsHandling = "Please consider taking advantage of JSON_THROW_ON_ERROR flag for this call options.";

    @NotNull
    @Override
    public String getShortName() {
        return "JsonEncodingApiUsageInspection";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "JSON encoding API usage";
    }

    @Override
    @NotNull
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new BasePhpElementVisitor() {
            @Override
            public void visitPhpFunctionCall(@NotNull FunctionReference reference) {
                final String functionName = reference.getName();
                if (functionName != null) {
                    if (functionName.equals("json_decode") && this.isFromRootNamespace(reference)) {
                        final PsiElement[] arguments = reference.getParameters();
                        if (HARDEN_DECODING_RESULT_TYPE && arguments.length == 1) {
                            final String replacement = String.format(
                                    "%sjson_decode(%s, %s)",
                                    reference.getImmediateNamespaceName(),
                                    arguments[0].getText(),
                                    DECODE_AS_ARRAY ? "true" : "false"
                            );
                            holder.registerProblem(
                                    reference,
                                    MessagesPresentationUtil.prefixWithEa(messageResultType),
                                    DECODE_AS_ARRAY ? new DecodeIntoArrayFix(replacement) : new DecodeIntoObjectFix(replacement)
                            );
                        }
                        if (HARDEN_ERRORS_HANDLING && arguments.length > 0 && PhpLanguageLevel.get(holder.getProject()).atLeast(PhpLanguageLevel.PHP730)) {
                            final boolean hasFlag = arguments.length >= 4 && this.hasThrowOnErrorFlag(arguments[3]);
                            if (! hasFlag) {
                                final String replacement = String.format(
                                        "%sjson_decode(%s, %s, %s, %s)",
                                        reference.getImmediateNamespaceName(),
                                        arguments[0].getText(),
                                        arguments.length > 1 ? arguments[1].getText() : (HARDEN_DECODING_RESULT_TYPE && DECODE_AS_ARRAY ? "true" : "false"),
                                        arguments.length > 2 ? arguments[2].getText() : "512",
                                        arguments.length > 3 ? "JSON_THROW_ON_ERROR | " + arguments[3].getText() : "JSON_THROW_ON_ERROR"
                                );
                                holder.registerProblem(
                                        reference,
                                        MessagesPresentationUtil.prefixWithEa(messageErrorsHandling),
                                        new HardenErrorsHandlingFix(replacement)
                                );
                            }
                        }
                    } else if (functionName.equals("json_encode") && this.isFromRootNamespace(reference)) {
                        if (HARDEN_ERRORS_HANDLING && PhpLanguageLevel.get(holder.getProject()).atLeast(PhpLanguageLevel.PHP730)) {
                            final PsiElement[] arguments = reference.getParameters();
                            final boolean hasFlag        = arguments.length >= 2 && this.hasThrowOnErrorFlag(arguments[1]);
                            if (!hasFlag && arguments.length > 0) {
                                final String replacement;
                                if (arguments.length > 2) {
                                    replacement = String.format(
                                            "%sjson_encode(%s, %s, %s)",
                                            reference.getImmediateNamespaceName(),
                                            arguments[0].getText(),
                                            "JSON_THROW_ON_ERROR | " + arguments[1].getText(),
                                            arguments[2].getText()
                                    );
                                } else {
                                    replacement = String.format(
                                            "%sjson_encode(%s, %s)",
                                            reference.getImmediateNamespaceName(),
                                            arguments[0].getText(),
                                            arguments.length > 1 ? "JSON_THROW_ON_ERROR | " + arguments[1].getText() : "JSON_THROW_ON_ERROR"
                                    );
                                }
                                holder.registerProblem(
                                        reference,
                                        MessagesPresentationUtil.prefixWithEa(messageErrorsHandling),
                                        new HardenErrorsHandlingFix(replacement)
                                );
                            }
                        }
                    }
                }
            }

            private boolean hasThrowOnErrorFlag(@NotNull PsiElement argument) {
                boolean hasFlag               = false;
                final Set<PsiElement> options = argument instanceof ConstantReference
                                                    ? new HashSet<>(Collections.singletonList(argument))
                                                    : PossibleValuesDiscoveryUtil.discover(argument);
                if (options.size() == 1) {
                    final PsiElement option = options.iterator().next();
                    if (OpenapiTypesUtil.isNumber(option)) {
                        /* JSON_THROW_ON_ERROR constant value gets resolved */
                        hasFlag = option.getText().equals("4194304");
                    } else if (option instanceof ConstantReference) {
                        /* JSON_THROW_ON_ERROR constant values is not getting resolved (no clue why, but happens) */
                        hasFlag = "JSON_THROW_ON_ERROR".equals(((ConstantReference) option).getName());
                    } else {
                        /* a complex case like local variable or implicit flags combination */
                        hasFlag = PsiTreeUtil.findChildrenOfType(option, ConstantReference.class).stream().anyMatch(r -> "JSON_THROW_ON_ERROR".equals(r.getName()));
                    }
                }
                options.clear();
                return hasFlag;
            }
        };
    }

    public JComponent createOptionsPanel() {
        return OptionsComponent.create((component) -> {
                component.addCheckbox("Harden decoding return type", HARDEN_DECODING_RESULT_TYPE, (isSelected) -> HARDEN_DECODING_RESULT_TYPE = isSelected);
                component.delegateRadioCreation(radio -> {
                    radio.addOption("Prefer decoding as array", DECODE_AS_ARRAY, (isSelected) -> DECODE_AS_ARRAY = isSelected);
                    radio.addOption("Prefer decoding as object", DECODE_AS_OBJECT, (isSelected) -> DECODE_AS_OBJECT = isSelected);
                });
                component.addCheckbox("Harden errors handling", HARDEN_ERRORS_HANDLING, (isSelected) -> HARDEN_ERRORS_HANDLING = isSelected);
        });
    }

    private static final class DecodeIntoArrayFix extends UseSuggestedReplacementFixer {
        private static final String title = "Decode into an array";

        @NotNull
        @Override
        public String getName() {
            return MessagesPresentationUtil.prefixWithEa(title);
        }

        DecodeIntoArrayFix(@NotNull String expression) {
            super(expression);
        }
    }

    private static final class HardenErrorsHandlingFix extends UseSuggestedReplacementFixer {
        private static final String title = "Harden errors handling";

        @NotNull
        @Override
        public String getName() {
            return MessagesPresentationUtil.prefixWithEa(title);
        }

        HardenErrorsHandlingFix(@NotNull String expression) {
            super(expression);
        }
    }

    private static final class DecodeIntoObjectFix extends UseSuggestedReplacementFixer {
        private static final String title = "Decode into an object";

        @NotNull
        @Override
        public String getName() {
            return MessagesPresentationUtil.prefixWithEa(title);
        }

        DecodeIntoObjectFix(@NotNull String expression) {
            super(expression);
        }
    }
}
