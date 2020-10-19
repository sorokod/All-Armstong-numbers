package org.xor.armstrong

import com.google.common.math.LongMath

fun Snk(n: Long, k: Long): Long =
    when {
        n == 1L -> 1
        k == 0L -> n
        else -> Snk(n - 1, k) + Snk(n, k - 1)
    }

fun Sn(n: Long): Long =
    (1..9).fold(0L, { sum, i -> sum + Snk(n, i.toLong()) })

fun SnBinomial(n: Int) =
    (1..9).fold(0L, { acc, k -> acc + LongMath.binomial(n + k, k + 1) })

fun SnBinomialClosedForm(n: Int) =
    LongMath.binomial(n + 9 + 1, n) - n - 1


