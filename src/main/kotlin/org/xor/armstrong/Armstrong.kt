package org.xor.armstrong

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

const val MAX_LEVEL = 39

/**
 * Generate all Armstrong numbers up to the given level
 */
fun armstrong(level: Int): Set<String> =
    Representatives().seq(level).filter { digits -> verify(digits) }.map { aSum(it) }.toSet()

fun printSorted(set: Set<String>) =
    println(set.sortedWith { a, b -> a.length - b.length })


@ExperimentalTime
fun main() {
    measureTime {
//        armstrong(level = 15).also { printSorted(it) } //1.6s
        armstrong(level = 20).also { printSorted(it) } //14s
//        armstrong(30).also { printSorted(it) } //600s
//        armstrong(MAX_LEVEL).also { printSorted(it) }
    }.also { duration -> println(duration) }
}