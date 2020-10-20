package org.xor.armstrong

import java.math.BigInteger
import java.math.BigInteger.ZERO


/**
 * A pre-calculated power table of values {0..9} to powers {1..MAX_LEVEL}.
 * Represented as array of maps:
 *
 * 0 -> {0^1, 0^2, ... , 0^MAX_LEVEL}
 * ...
 * 9 -> {9^1, 9^2, ... , 9^MAX_LEVEL}
 */
object PowerTable {

    val POW_CACHE: Array<Map<Int, BigInteger>> = Array(10) { i ->
        (1..MAX_LEVEL).map { p -> p to BigInteger.valueOf(i.toLong()).pow(p) }.toMap()
    }

    inline fun pow(i: Int, p: Int): BigInteger = POW_CACHE[i][p]!!
    inline fun pow(i: Byte, p: Int): BigInteger = pow(i.toInt(), p)
}


/**
 * Computes the aSum of the digits, e.g: aSum ([8, 2, 0, 8]) = 8^4 + 2^4 + 0^4 + 8^4 = 8208
 */
inline fun aSum(digits: ByteArray): String =
    digits.fold(initial = ZERO, operation = { acc, digit -> acc + PowerTable.pow(digit, digits.size) }).toString()


/**
 * By comparing the counts of distinct elements
 */
fun isPermutation(b: ByteArray, s: String): Boolean {
    if (s.length != b.size) {
        return false
    }
    val digitCounter = IntArray(10)

    for (element in s) {
        digitCounter[element - '0']++
    }

    for (i in b.indices) {
        val c = b[i].toInt()
        if (digitCounter[c] == 0) {
            return false
        }
        digitCounter[c]--
    }

    return (digitCounter.firstOrNull { it != 0 } == null)
}


fun verify(digits: ByteArray): Boolean =
    isPermutation(digits, aSum(digits));
