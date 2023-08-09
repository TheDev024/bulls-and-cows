package org.td024.bullsandcows

class Grader(private val secret: String, private val guess: String) {
    fun grade(): String {
        var bulls = 0
        var cows = 0

        guess.forEachIndexed { index, digit ->
            if (secret[index] == digit) bulls++
            else if (secret.contains(digit)) cows++
        }

        val totalBulls = if (bulls > 0) " $bulls bull(s)" else ""
        val totalCows = if (cows > 0) " $cows cow(s)" else ""
        val none = if (bulls == 0 && cows == 0) " None" else ""

        return "Grade:$totalBulls$totalCows$none. The secret code is $secret"
    }
}
