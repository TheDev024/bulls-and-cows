package org.td024.bullsandcows

import java.util.*

val random = Random()
val scanner = Scanner(System.`in`)

fun main() {
    val game = BullsAndCows()
    game.guess()
}