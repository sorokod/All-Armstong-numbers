package org.xor.armstrong

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger


class VerifierTest {

    @Test
    fun `isPermutation is correct`() {
        assertTrue(isPermutation(byteArrayOf(1, 2, 3), "123"))
        assertTrue(isPermutation(byteArrayOf(1, 2, 3), "231"))
        assertTrue(isPermutation(byteArrayOf(1, 3, 2), "231"))

        assertFalse(isPermutation(byteArrayOf(1, 2, 3), "311"))
        assertFalse(isPermutation(byteArrayOf(1, 2, 3), "12"))
        assertFalse(isPermutation(byteArrayOf(1, 2), "123"))
    }

    @Test
    fun `aSum is correct`() {
        assertEquals("153", aSum(byteArrayOf(1, 5, 3)))
        assertEquals("153", aSum(byteArrayOf(5, 3, 1)))
        assertNotEquals("1", aSum(byteArrayOf(1, 5, 3)))
    }

    @Test
    fun `test pow(i,p) `() {
        for (i in 0..9) {
            for (p in 1..MAX_LEVEL) {
                val expected = BigInteger.valueOf(i.toLong()).pow(p)
                val actual = PowerTable.pow(i, p)

                assertEquals(expected, actual)
            }
        }
    }
}
