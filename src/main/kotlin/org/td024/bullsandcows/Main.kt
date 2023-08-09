package org.td024.bullsandcows

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val game = BullsAndCows()
    game.guess()
}

class IO {

    companion object {

        fun getInt(message: String, errorMessage: String? = null, range: IntRange? = null): Int {
            println(message)
            val input = scanner.nextInt()
            scanner.nextLine() // To avoid later nextLine errors
            if (range != null && input !in range) {
                println(errorMessage)
                return getInt(message, errorMessage, range)
            }
            return input
        }

        fun getLine(message: String): String {
            println(message)
            return scanner.nextLine()
        }
    }
}
