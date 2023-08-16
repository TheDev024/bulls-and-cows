package org.td024.bullsandcows

class IO {

    companion object {

        fun get(
            message: String? = null, errorMessage: String? = null, condition: ((String) -> Boolean)? = null
        ): String {
            if (message != null) println(message)
            val input = scanner.next()
            if (condition == null || condition(input)) return input
            if (errorMessage != null) println(errorMessage)
            return get(message, errorMessage, condition)
        }

        /*fun getLine(
            message: String? = null, errorMessage: String? = null, condition: ((String) -> Boolean)? = null
        ): String {
            if (message != null) println(message)
            val input = scanner.nextLine()
            if (condition == null || condition(input)) return input
            if (errorMessage != null) println(errorMessage)
            return getLine(message, errorMessage, condition)
        }*/

        fun getInt(message: String? = null, errorMessage: String? = null, condition: ((Int) -> Boolean)? = null): Int {
            if (message != null) println(message)
            val input = try {
                scanner.nextLine().toInt()
            } catch (e: Exception) {
                println("Error: Invalid number format!")
                getInt(message, errorMessage, condition)
            }
            if (condition == null || condition(input)) return input
            if (errorMessage != null) println(errorMessage)
            return getInt(message, errorMessage, condition)
        }
    }
}