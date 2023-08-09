package org.td024.bullsandcows

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