# Rules (Inspections) list

Abbreviations meaning:

- QF   - Quick-Fix;
- UTs  - Inspection has tests;
- QFTs - Inspection has QF tests;
- Doc  - documentation at GitHub (IDE also has shorter version of inspections descriptions, not reflected in the list);

Inspections Lists (Type compatibility)
---
| Group                | Short Name                                      | Full Name                                              | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :----------------------------------------------------- | --: | --: | ---: | --: |
| Type compatibility   | IsEmptyFunctionUsageInspection                  | 'empty(...)' usage                                     | yes | yes | yes  | yes |
| Type compatibility   | TypeUnsafeComparisonInspection                  | Type unsafe comparison                                 | yes | yes | yes  | yes |
| Type compatibility   | TypeUnsafeArraySearchInspection                 | 'in_array(...)', 'array_search(...)' type unsafe usage | yes | yes | yes  | yes |
| Type compatibility   | JsonEncodingApiUsageInspection                  | JSON encoding API usage                                | yes | yes | yes  | yes |

Inspections Lists (Control flow)
---
| Group                | Short Name                                      | Full Name                                                                         | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------------------------------------- | --: | --: | ---: | --: |
| Control Flow         | UnSafeIsSetOverArrayInspection                  | 'isset(...)' usage                                                                | yes | yes | yes  | no  |
| Control Flow         | TernaryOperatorSimplifyInspection               | Ternary operator could be simplified                                              | yes | yes | yes  | yes |
| Control Flow         | IfReturnReturnSimplificationInspection          | If-return-return could be simplified                                              | yes | yes | yes  | yes |
| Control Flow         | NotOptimalIfConditionsInspection                | Non-optimal if conditions                                                         | n/a | yes | n/a  | yes |
| Control Flow         | LoopWhichDoesNotLoopInspection                  | Loop which does not loop                                                          | n/a | yes | n/a  | yes |
| Control Flow         | ThrowRawExceptionInspection                     | General exception is thrown                                                       | yes | yes | yes  | yes |
| Control Flow         | DisconnectedForeachInstructionInspection        | Statement could be decoupled from foreach                                         | n/a | yes | n/a  | yes |
| Control Flow         | DegradedSwitchInspection                        | Switch-case could be simplified                                                   | n/a | yes | n/a  | yes |
| Control Flow         | ForeachInvariantsInspection                     | Foreach usage possible                                                            | yes | yes | yes  | yes |
| Control Flow         | PdoApiUsageInspection                           | PDO API usage                                                                     | yes | yes | yes  | yes |
| Control Flow         | OneTimeUseVariablesInspection                   | One-time use variables                                                            | yes | yes | yes  | yes |
| Control Flow         | MultiAssignmentUsageInspection                  | 'list(...) = ' usage possible                                                     | n/a | yes | n/a  | yes |
| Control Flow         | GetTypeMissUseInspection                        | 'gettype(...)' could be replaced with 'is_*(...)'                                 | yes | yes | yes  | yes |
| Control Flow         | ArraySearchUsedAsInArrayInspection              | 'array_search(...)' could be replaced by 'in_array(...)'                          | yes | yes | yes  | yes |
| Control Flow         | StrTrUsageAsStrReplaceInspection                | 'strtr(...)' could be replaced with 'str_replace(...)'                            | yes | yes | yes  | yes |
| Control Flow         | SubStrUsedAsStrPosInspection                    | 'substr(...)' could be replaced with 'strpos(...)'                                | yes | yes | yes  | yes |
| Control Flow         | StringNormalizationInspection                   | Strings normalization                                                             | yes | yes | yes  | yes |
| Control Flow         | RedundantElseClauseInspection                   | Redundant 'else' keyword                                                          | yes | yes | yes  | yes |
| Control Flow         | InvertedIfElseConstructsInspection              | Inverted 'if-else' constructs                                                     | yes | yes | yes  | yes |
| Control Flow         | StringCaseManipulationInspection                | Unnecessary string case manipulation                                              | yes | yes | yes  | yes |
| Control Flow         | ArrayUniqueCanBeUsedInspection                  | 'array_unique(...)' can be used                                                   | yes | yes | yes  | yes |
| Control Flow         | CompactCanBeUsedInspection                      | 'compact(...)' can be used                                                        | yes | yes | yes  | yes |
| Control Flow         | IssetConstructsCanBeMergedInspection            | 'isset(...)' constructs can be merged                                             | yes | yes | yes  | yes |
| Control Flow         | StrlenInEmptyStringCheckContextInspection       | 'strlen(...)' misused                                                             | yes | yes | yes  | yes |
| Control Flow         | ObGetCleanCanBeUsedInspection                   | 'ob_get_clean()' can be used                                                      | yes | yes | yes  | yes |

Inspections Lists (PHPUnit)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | --:  | --: |
| PHPUnit              | PhpUnitTestsInspection                          | PHPUnit: bugs and best practices                    | yes | yes | yes  | n/a |
| PHPUnit              | UnnecessaryAssertionInspection                  | PHPUnit: unnecessary assertion                      | yes | yes | yes  | n/a |
| PHPUnit              | MockingMethodsCorrectnessInspection             | PHPUnit: methods mocking issues                     | yes | yes | yes  | n/a |
| PHPUnit              | PhpUnitDeprecationsInspection                   | PHPUnit: API deprecations                           | n/a | yes | n/a  | n/a |

Inspections Lists (Unused)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | --: |
| Unused               | OnlyWritesOnParameterInspection                 | Parameter/variable is not used                      | n/a | yes | n/a  | yes |
| Unused               | UselessUnsetInspection                          | Useless unset                                       | n/a | yes | n/a  | yes |
| Unused               | PropertyInitializationFlawsInspection           | Class property initialization flaws                 | yes | yes | yes  | yes |
| Unused               | UnusedConstructorDependenciesInspection         | Unused constructor dependencies                     | n/a | yes | n/a  | yes |
| Unused               | SenselessProxyMethodInspection                  | Senseless proxy function                            | yes | yes | yes  | yes |
| Unused               | SenselessMethodDuplicationInspection            | Child method is exactly the same                    | yes | yes | yes  | yes |
| Unused               | UnusedGotoLabelInspection                       | Unused goto labels                                  | yes | yes | yes  | n/a |
| Unused               | ArgumentEqualsDefaultValueInspection            | Unnecessary call arguments specification            | yes | yes | yes  | yes |
| Unused               | UnnecessaryIssetArgumentsInspection             | Unnecessary isset arguments specification           | yes | yes | yes  | yes |
| Unused               | DateUsageInspection                             | Unnecessary 'date(...)' arguments specification     | yes | yes | yes  | yes |

Inspections Lists (Compatibility)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | --: |
| Compatibility        | DeprecatedIniOptionsInspection                  | Deprecated configuration options                    | n/a | yes | n/a  | n/a |
| Compatibility        | RandomApiMigrationInspection                    | Random API migration                                | yes | yes | yes  | n/a |
| Compatibility        | MktimeUsageInspection                           | 'gmmktime(...)'/'mktime(...)' usage                 | yes | yes | yes  | n/a |
| Compatibility        | FopenBinaryUnsafeUsageInspection                | Binary-unsafe 'fopen(...)' usage                    | yes | yes | yes  | n/a |

Inspections Lists (Confusing constructs)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | --: |
| Confusing constructs | SenselessTernaryOperatorInspection              | Suspicious ternary operator                         | yes | yes | yes  | yes |
| Confusing constructs | ClassMethodNameMatchesFieldNameInspection       | Method name matches existing field name             | n/a | yes | n/a  | yes |
| Confusing constructs | NestedTernaryOperatorInspection                 | Nested ternary operator                             | n/a | yes | n/a  | yes |
| Confusing constructs | UselessReturnInspection                         | Useless return                                      | yes | yes | yes  | yes |
| Confusing constructs | ReferencingObjectsInspection                    | Referencing objects                                 | yes | yes | yes  | yes |

Inspections Lists (Code style)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc  |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | ---: |
| Code Style           | UnNecessaryDoubleQuotesInspection               | Unnecessary double quotes                           | yes | yes | yes  | n/a  |
| Code Style           | MissingOrEmptyGroupStatementInspection          | Missing or empty conditionals group statement       | yes | yes | yes  | n/a |
| Code Style           | AccessModifierPresentedInspection               | Access modifiers shall be defined                   | yes | yes | yes  | yes |
| Code Style           | NestedPositiveIfStatementsInspection            | Nested positive ifs                                 | yes | yes | yes  | no  |
| Code Style           | StaticInvocationViaThisInspection               | Static methods invocation via '->'                  | yes | yes | yes  | n/a |
| Code Style           | DynamicInvocationViaScopeResolutionInspection   | Dynamic methods invocation via '::'                 | yes | yes | yes  | n/a |
| Code Style           | UnnecessarySemicolonInspection                  | Unnecessary semicolon                               | yes | yes | yes  | n/a |
| Code Style           | UnnecessaryUseAliasInspection                   | Unnecessary use aliases                             | yes | yes | yes  | no  |
| Code Style           | NestedNotOperatorsInspection                    | Nested not operators usage                          | yes | yes | yes  | no  |
| Code Style           | IncrementDecrementOperationEquivalentInspection | Increment/decrement operation equivalent            | yes | yes | yes  | no  |
| Code Style           | OpAssignShortSyntaxInspection                   | Short syntax for applied operation                  | yes | yes | yes  | no  |
| Code Style           | UnnecessaryFinalModifierInspection              | Unnecessary final modifiers                         | yes | yes | yes  | no  |
| Code Style           | UsingInclusionReturnValueInspection             | Usage of inclusion return value                     | n/a | yes | n/a  | no  |
| Code Style           | ShortOpenTagUsageInspection                     | PHP short open tag usage                            | yes | yes | yes  | no  |
| Code Style           | ComparisonOperandsOrderInspection               | Yoda/regular conditions style usage                 | yes | yes | yes  | no  |
| Code Style           | UnknownInspectionInspection                     | Unknown inspection suppression                      | n/a | yes | n/a  | no  |
| Code Style           | ParameterDefaultValueIsNotNullInspection        | Non-null parameters default value                   | n/a | yes | n/a  | yes |
| Code Style           | MisorderedModifiersInspection                   | PSR-compliant modifiers order                       | yes | yes | yes  | no  |
| Code Style           | DisallowWritingIntoStaticPropertiesInspection   | Disallow writing into static properties             | n/a | yes | n/a  | no  |
| Code Style           | UnnecessaryCastingInspection                    | Unnecessary type casting                            | yes | yes | yes  | no  |
| Code Style           | SelfClassReferencingInspection                  | Self class referencing                              | yes | yes | yes  | no  |
| Code Style           | MissUsingParentKeywordInspection                | 'parent' keyword misused                            | yes | yes | yes  | no  |
| Code Style           | NestedAssignmentsUsageInspection                | Nested assignments usage                            | yes | yes | yes  | no  |
| Code Style           | ProperNullCoalescingOperatorUsageInspection     | Proper null-coalescing operator usage               | yes | yes | yes  | no  |
| Code Style           | StaticClosureCanBeUsedInspection                | Static closure can be used                          | yes | yes | yes  | no  |
| Code Style           | ImplodeArgumentsOrderInspection                 | 'implode(...)' arguments order                      | yes | yes | yes  | no  |
| Code Style           | ShortEchoTagCanBeUsedInspection                 | Short echo tag can be used                          | yes | yes | yes  | no  |
| Code Style           | IsNullFunctionUsageInspection                   | 'null === ...' can be used                          | yes | yes | yes  | no  |
| Code Style           | UnsetConstructsCanBeMergedInspection            | 'unset(...)' constructs can be merged               | yes | yes | yes  | yes |

Inspections Lists (Language level migration)
---
| Group                    | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :----------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | --: |
| Language level migration | ElvisOperatorCanBeUsedInspection                | Elvis operator can be used                          | yes | yes | yes  | no  |
| Language level migration | NullCoalescingOperatorCanBeUsedInspection       | Null coalescing operator can be used                | yes | yes | yes  | no  |
| Language level migration | TypesCastingCanBeUsedInspection                 | Type casting can be used                            | yes | yes | yes  | no  |
| Language level migration | DirectoryConstantCanBeUsedInspection            | __DIR__ constant can be used                        | yes | yes | yes  | no  |
| Language level migration | ShortListSyntaxCanBeUsedInspection              | Short list syntax can be used                       | yes | yes | yes  | no  |
| Language level migration | DeprecatedConstructorStyleInspection            | Deprecated constructor style                        | yes | yes | yes  | no  |
| Language level migration | AliasFunctionsUsageInspection                   | Alias functions usage                               | yes | yes | yes  | yes |
| Language level migration | ClassConstantCanBeUsedInspection                | ::class can be used                                 | yes | yes | yes  | no  |
| Language level migration | CascadingDirnameCallsInspection                 | Cascading dirname(...) calls                        | yes | yes | yes  | no  |
| Language level migration | PowerOperatorCanBeUsedInspection                | Power operator can be used                          | yes | yes | yes  | no  |
| Language level migration | ConstantCanBeUsedInspection                     | A constant can be used                              | yes | yes | yes  | no  |
| Language level migration | ArgumentUnpackingCanBeUsedInspection            | Argument unpacking can be used                      | yes | yes | yes  | no  |
| Language level migration | ReturnTypeCanBeDeclaredInspection               | Return type hint can be used                        | yes | yes | yes  | no  |
| Language level migration | GetClassUsageInspection                         | 'get_class(...)' usage correctness                  | n/a | yes | n/a  | no  |
| Language level migration | UnsupportedStringOffsetOperationsInspection     | Unsupported string offset operations                | n/a | yes | n/a  | no  |
| Language level migration | InstanceofCanBeUsedInspection                   | 'instanceof' can be used                            | yes | yes | yes  | no  |
| Language level migration | DynamicCallsToScopeIntrospectionInspection      | Deprecated dynamic calls to scope introspection     | n/a | yes | n/a  | no  |
| Language level migration | UnsupportedEmptyListAssignmentsInspection       | Unsupported empty list assignments                  | n/a | yes | n/a  | no  |
| Language level migration | IsIterableCanBeUsedInspection                   | 'is_iterable(...)' can be used                      | n/a | yes | n/a  | no  |
| Language level migration | IsCountableCanBeUsedInspection                  | 'is_countable(...)' can be used                     | n/a | yes | n/a  | no  |
| Language level migration | StrContainsCanBeUsedInspection                  | 'str_contains(...)' can be used                     | yes | yes | yes  | no  |
| Language level migration | StrStartsWithCanBeUsedInspection                | 'str_starts_with(...)' can be used                  | yes | yes | yes  | no  |
| Language level migration | StrEndsWithCanBeUsedInspection                  | 'str_ends_with(...)' can be used                    | yes | yes | yes  | no  |
| Language level migration | GetDebugTypeCanBeUsedInspection                 | 'get_debug_type(...)' can be used                   | yes | yes | yes  | no  |

Inspections Lists (Architecture)
---
| Group                | Short Name                                      | Full Name                                           | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :-------------------------------------------------- | --: | --: | ---: | --: |
| Architecture         | BadExceptionsProcessingInspection               | Badly organized exception handling                  | n/a | yes | n/a  | yes |
| Architecture         | CallableParameterUseCaseInTypeContextInspection | Callable parameter usage violates definition        | n/a | yes | n/a  | yes |
| Architecture         | ClassOverridesFieldOfSuperClassInspection       | Class overrides a field of a parent class           | n/a | yes | n/a  | yes |
| Architecture         | LongInheritanceChainInspection                  | Long inheritance chain                              | n/a | yes | n/a  | yes |
| Architecture         | PropertyCanBeStaticInspection                   | Property could be static                            | n/a | yes | n/a  | no  |
| Architecture         | EmptyClassInspection                            | Empty class                                         | n/a | yes | n/a  | yes |
| Architecture         | ClassReImplementsParentInterfaceInspection      | Class implements interfaces multiple times          | yes | yes | yes  | yes |
| Architecture         | MultipleReturnStatementsInspection              | Multiple return statements usage                    | n/a | yes | n/a  | yes |
| Architecture         | EfferentObjectCouplingInspection                | Efferent coupling between objects                   | n/a | yes | n/a  | no  |

Inspections Lists (Probable bugs)
---
| Group                | Short Name                                      | Full Name                                                 | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------    | :--------------------------------------------------       | --: | --: | ---: | --: |
| Probable bugs        | ForgottenDebugOutputInspection                  | Forgotten debug statements                                | n/a | yes | n/a  | yes |
| Probable bugs        | MagicMethodsValidityInspection                  | Magic methods validity                                    | n/a | yes | n/a  | n/a |
| Probable bugs        | SuspiciousLoopInspection                        | Suspicious loop                                           | n/a | yes | n/a  | yes |
| Probable bugs        | PrintfScanfArgumentsInspection                  | *printf/*scanf arguments count mismatches                 | n/a | yes | n/a  | n/a |
| Probable bugs        | RealpathInStreamContextInspection               | Phar-incompatible 'realpath(...)' usage                   | yes | yes | yes  | yes |
| Probable bugs        | OffsetOperationsInspection                      | Array and string offset validity                          | n/a | yes | n/a  | n/a |
| Probable bugs        | MkdirRaceConditionInspection                    | 'mkdir(...)' race condition                               | n/a | yes | n/a  | yes |
| Probable bugs        | IncorrectRandomRangeInspection                  | Incorrect random generation range                         | n/a | yes | n/a  | yes |
| Probable bugs        | SuspiciousSemicolonInspection                   | Suspicious semicolon                                      | n/a | yes | n/a  | no  |
| Probable bugs        | SwitchContinuationInLoopInspection              | Continue misbehaviour in switch                           | yes | yes | yes  | yes |
| Probable bugs        | CompactArgumentsInspection                      | 'compact(...)' variables existence                        | n/a | yes | n/a  | yes |
| Probable bugs        | DateIntervalSpecificationInspection             | Date interval specification validity                      | n/a | yes | n/a  | n/a |
| Probable bugs        | UsingInclusionOnceReturnValueInspection         | Suspicious usage of include_once/require_once return value| yes | yes | yes  | no  |
| Probable bugs        | PregQuoteUsageInspection                        | Proper preg_quote(...) usage                              | n/a | yes | n/a  | yes |
| Probable bugs        | SuspiciousAssignmentsInspection                 | Suspicious assignments                                    | n/a | yes | n/a  | no  |
| Probable bugs        | DateTimeConstantsUsageInspection                | DateTime constants usage validity                         | yes | yes | yes  | n/a |
| Probable bugs        | SuspiciousReturnInspection                      | Suspicious returns                                        | n/a | yes | n/a  | n/a |
| Probable bugs        | SuspiciousBinaryOperationInspection             | Suspicious binary operations                              | n/a | yes | n/a  | n/a |
| Probable bugs        | AutoloadingIssuesInspection                     | Class autoloading correctness                             | n/a | yes | n/a  | yes |
| Probable bugs        | IssetArgumentExistenceInspection                | Isset operations variables existence                      | n/a | yes | n/a  | no  |
| Probable bugs        | TraitsPropertiesConflictsInspection             | Traits properties conflicts resolution                    | n/a | yes | n/a  | n/a |
| Probable bugs        | NullPointerExceptionInspection                  | Null reference                                            | n/a | yes | n/a  | yes |
| Probable bugs        | MissingIssetImplementationInspection            | Empty/isset results correctness                           | n/a | yes | n/a  | yes |
| Probable bugs        | CallableMethodValidityInspection                | Callable methods validity                                 | n/a | yes | n/a  | no  |
| Probable bugs        | PassingByReferenceCorrectnessInspection         | Passing arguments by reference correctness                | n/a | yes | n/a  | n/a |
| Probable bugs        | ClassMockingCorrectnessInspection               | Class mocking correctness                                 | n/a | yes | n/a  | no  |
| Probable bugs        | ClassConstantUsageCorrectnessInspection         | ::class constant usage correctness                        | n/a | yes | n/a  | yes |
| Probable bugs        | DeclareDirectiveCorrectnessInspection           | Declare directive correctness                             | n/a | yes | n/a  | n/a |
| Probable bugs        | InfinityLoopInspection                          | Infinity loop detection                                   | n/a | yes | n/a  | no  |
| Probable bugs        | StringsFirstCharactersCompareInspection         | Strings N-character comparison flaws                      | yes | yes | yes  | no  |
| Probable bugs        | SimpleXmlLoadFileUsageInspection                | 'simplexml_load_file(...)' usage correctness              | yes | yes | yes  | n/a |
| Probable bugs        | DateTimeSetTimeUsageInspection                  | 'DateTime::setTime(...)' usage correctness                | n/a | yes | n/a  | n/a |
| Probable bugs        | MissingArrayInitializationInspection            | Missing array initialization                              | n/a | yes | n/a  | no  |
| Probable bugs        | DuplicateArrayKeysInspection                    | Duplicate array keys                                      | n/a | yes | n/a  | n/a |
| Probable bugs        | SuspiciousFunctionCallsInspection               | Suspicious function calls                                 | n/a | yes | n/a  | no  |
| Probable bugs        | PreloadingUsageCorrectnessInspection            | Preloading usage correctness                              | yes | yes | yes  | n/a |
| Probable bugs        | StaticLambdaBindingInspection                   | Static lambdas binding                                    | yes | yes | yes  | no  |

Inspections Lists (Security)
---
| Group                | Short Name                                         | Full Name                                                         | QF  | UTs | QFTs | Doc |
| :------------------- | :-------------------------------------------       | :---------------------------------------------------------------- | --: | --: | ---: | --: |
| Security             | NonSecureUniqidUsageInspection                     | Insecure 'uniqid(...)' usage (Insufficient Entropy Vulnerability) | yes | yes | yes  | n/a |
| Security             | NonSecureExtractUsageInspection                    | Insecure 'extract(...)' usage (Variable extract Vulnerability)    | n/a | yes | n/a  | yes |
| Security             | NonSecureParseStrUsageInspection                   | Insecure 'parse_str(...)' usage (Variable extract Vulnerability)  | n/a | yes | n/a  | yes |
| Security             | UntrustedInclusionInspection                       | Untrusted files inclusion                                         | n/a | yes | n/a  | yes |
| Security             | SecurityAdvisoriesInspection                       | Security advisories for Composer packages                         | yes | yes | yes  | yes |
| Security             | CurlSslServerSpoofingInspection                    | CURL: SSL server spoofing (SSL MITM and Spoofing Attacks)         | n/a | yes | n/a  | yes |
| Security             | EncryptionInitializationVectorRandomnessInspection | Encryption initialization vector randomness                       | n/a | yes | n/a  | n/a |
| Security             | UnserializeExploitsInspection                      | Exploiting unserialize (PHP Object Injection Vulnerability)       | n/a | yes | n/a  | yes |
| Security             | PotentialMalwareInspection                         | Basic malware patterns                                            | n/a | yes | n/a  | yes |
| Security             | CryptographicallySecureRandomnessInspection        | Cryptographically secure randomness                               | n/a | yes | n/a  | yes |
| Security             | CryptographicallySecureAlgorithmsInspection        | Cryptographically secure algorithms                               | n/a | yes | n/a  | yes |
| Security             | HostnameSubstitutionInspection                     | Hostname substitution                                             | n/a | yes | n/a  | n/a |
| Security             | BacktickOperatorUsageInspection                    | Backtick operator usage                                           | yes | yes | yes  | n/a |

Inspections Lists (Performance)
---
| Group                | Short Name                                      | Full Name                                                                                         | QF  | UTs | QFTs | Doc |
| :------------------- | :---------------------------------------------- | :------------------------------------------------------------------------------------------------ | --: | --: | ---: | --: |
| Performance          | AmbiguousMethodsCallsInArrayMappingInspection   | Non-optimized arrays mapping                                                                      | n/a | yes | n/a  | yes |
| Performance          | SlowArrayOperationsInLoopInspection             | Slow array function used in loop                                                                  | yes | yes | yes  | yes |
| Performance          | StrStrUsedAsStrPosInspection                    | 'str(i)str(...)' could be replaced with 'str(i)pos(...)'                                          | yes | yes | yes  | no  |
| Performance          | AlterInForeachInspection                        | Foreach variables reference usage correctness                                                     | n/a | yes | n/a  | yes |
| Performance          | ArrayPushMissUseInspection                      | 'array_push(...)' misused                                                                         | yes | yes | yes  | no  |
| Performance          | NotOptimalRegularExpressionsInspection          | Non-optimal regular expression                                                                    | n/a | yes | n/a  | yes | 
| Performance          | VariableFunctionsUsageInspection                | Variable functions usage                                                                          | yes | yes | yes  | no  |
| Performance          | SubStrShortHandUsageInspection                  | 'substr(...)' short-hand usage                                                                    | yes | yes | yes  | no  |
| Performance          | InArrayMissUseInspection                        | 'in_array(...)' misused                                                                           | yes | yes | yes  | no  |
| Performance          | CaseInsensitiveStringFunctionsMissUseInspection | 'stristr(...)/stripos(...)/strripos(...)' could be replaced with 'strstr(...)/strpos()/strrpos()' | yes | yes | yes  | no  |
| Performance          | SubStrUsedAsArrayAccessInspection               | 'substr(...)' used as index-based access                                                          | yes | yes | yes  | no  |
| Performance          | CascadeStringReplacementInspection              | Cascading 'str_replace(...)' calls                                                                | yes | yes | yes  | no  |
| Performance          | StrtotimeUsageInspection                        | 'strtotime(...)' misused                                                                          | yes | yes | yes  | no  |
| Performance          | PackedHashtableOptimizationInspection           | Packed hashtable optimizations                                                                    | n/a | yes | n/a  | yes |
| Performance          | UnqualifiedReferenceInspection                  | Unqualified function/constant reference                                                           | yes | yes | yes  | no  |
| Performance          | FixedTimeStartWithInspection                    | Fixed-time string starts with checks                                                              | yes | yes | yes  | no  |
