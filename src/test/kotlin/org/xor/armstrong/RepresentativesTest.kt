package org.xor.armstrong

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RepresentativesTest {

    fun ByteArray.asString() = this.joinToString (separator = "")

    private val level2expected = listOf(
        "1", "10", "11", "2", "20", "21", "22", "3", "30", "31", "32", "33", "4", "40", "41", "42", "43", "44", "5",
        "50", "51", "52", "53", "54", "55", "6", "60", "61", "62", "63", "64", "65", "66", "7", "70", "71", "72", "73",
        "74", "75", "76", "77", "8", "80", "81", "82", "83", "84", "85", "86", "87", "88", "9", "90", "91", "92", "93",
        "94", "95", "96", "97", "98", "99"
    )

    @Test
    fun `should have expected level 2 representatives`() {
        val actual = Representatives().seq(level = 2).map { it.asString() }.toList()
        assertEquals(level2expected, actual)
    }


    @Test
    fun `should have expected level count`() {
        assertEquals(SnBinomialClosedForm(2), Representatives().seq(level = 2).count().toLong())
        assertEquals(SnBinomialClosedForm(3), Representatives().seq(level = 3).count().toLong())
        assertEquals(SnBinomialClosedForm(10), Representatives().seq(level = 10).count().toLong())
    }


}