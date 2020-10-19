package org.xor.armstrong

import com.google.common.math.LongMath.binomial
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SFunctionsTest {

    companion object {

        @JvmStatic
        fun SnkValues() = arrayOf(
            arrayOf(3, 1, 3 * 4 / 2),
            arrayOf(4, 1, 4 * 5 / 2),
            arrayOf(5, 1, 5 * 6 / 2),
            arrayOf(100, 1, 100 * 101 / 2),
            arrayOf(3, 2, 10)
        )

        @JvmStatic
        fun SnValues() = arrayOf(
            arrayOf(1, 9),
            arrayOf(2, 63),
            arrayOf(3, 282),
            arrayOf(MAX_LEVEL, 8_217_822_496),
        )

    }


    @ParameterizedTest(name = "S({0} , {1}) = {2}")
    @MethodSource("SnkValues")
    fun `S(n,k) `(n: Long, k: Long, expected: Long) {
        assertEquals(expected, Snk(n, k))
    }

    @ParameterizedTest(name = "S({0}) = {1}")
    @MethodSource("SnValues")
    fun `S(n)`(n: Long, expected: Long) {
        assertEquals(expected, Sn(n))
    }


    @ParameterizedTest(name = "SBinomial({0}) = {1}")
    @MethodSource("SnValues")
    fun `SBinomial(n) = S(n)`(n: Long, expected: Long) {
        assertEquals(SnBinomial(n.toInt()), expected)
    }

    @ParameterizedTest(name = "SBinomial({0}) = {1}")
    @MethodSource("SnValues")
    fun `SBinomialClosedForm(n) = S(n)`(n: Long, expected: Long) {
        assertEquals(SnBinomialClosedForm(n.toInt()), expected)
    }

}