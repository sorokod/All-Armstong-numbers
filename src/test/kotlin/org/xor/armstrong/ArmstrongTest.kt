package org.xor.armstrong

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private val LEVEL_3 = setOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "153", "370", "371", "407")
private val LEVEL_4 = LEVEL_3 + setOf("1634", "8208", "9474")
private val LEVEL_5 = LEVEL_4 + setOf("54748", "92727", "93084")

private val LEVEL_15 = setOf(
    "1", "2", "3", "4", "5", "6", "7", "8", "9",
    "153", "370", "371", "407",
    "1634", "8208", "9474",
    "54748", "92727", "93084",
    "548834",
    "1741725", "4210818", "9800817", "9926315",
    "24678050", "24678051", "88593477",
    "146511208", "472335975", "534494836", "912985153",
    "4679307774",
    "32164049650", "32164049651", "40028394225", "42678290603", "44708635679", "49388550606", "82693916578",
    "94204591914", "28116440335967"

)


class ArmstrongTest {
    @Test
    fun testLevels() {
        assertEquals(LEVEL_3, armstrong(level = 3))
        assertEquals(LEVEL_4, armstrong(level = 4))
        assertEquals(LEVEL_5, armstrong(level = 5))
        assertEquals(LEVEL_15, armstrong(level = 15))
    }
}