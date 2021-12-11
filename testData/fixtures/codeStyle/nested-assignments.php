<?php

function cases_holder()
{
    <weak_warning descr="[EA] Using dedicated assignment would be more reliable (e.g '$... = $... + 10' can be mistyped as `$... = $... = 10`).">$a = $b = 0</weak_warning>;

    <weak_warning descr="[EA] Using dedicated assignment would be more reliable (e.g '$... = $... + 10' can be mistyped as `$... = $... = 10`).">$a = $b = ''</weak_warning>;

    <weak_warning descr="[EA] Using dedicated assignment would be more reliable (e.g '$... = $... + 10' can be mistyped as `$... = $... = 10`).">$a = $b = $c = trim('')</weak_warning>;

    <weak_warning descr="[EA] Using dedicated assignment would be more reliable (e.g '$... = $... + 10' can be mistyped as `$... = $... = 10`).">$a = $b = $z</weak_warning>;

    /* false-positives */
    $a = 0;
}