package org.xor.armstrong

import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


class Representatives {

    private val stack: LinkedList<ByteArray> =
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).mapTo(LinkedList()) { digit -> byteArrayOf(digit.toByte()) }

    private fun nextChild(parent: ByteArray, digit: Int): ByteArray =
        parent.copyOf(parent.size + 1).also { it[it.lastIndex] = digit.toByte() }

    val dfs = { level: Int ->
        {
            if (stack.isEmpty()) {
                null
            } else {
                val value = stack.removeFirst()
                if (value.size < level) {
                    for (k in value[value.lastIndex] downTo 0) {
                        stack.addFirst(nextChild(value, k))
                    }
                }
                value
            }
        }
    }

    fun seq(level: Int): Sequence<ByteArray> =
        generateSequence { dfs(level)() }

}


@ExperimentalTime
fun main() {
    measureTime {
        Representatives().seq(level = 2).forEach { println(it.joinToString(separator = "")) }
        Representatives().seq(level = 2).count().also { println("count = $it") }
    }.also { println(it) }

}