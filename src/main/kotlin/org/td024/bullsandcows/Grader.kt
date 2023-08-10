package org.td024.bullsandcows

class Grader {
    fun grade(secret: String, guess: String): Pair<Int, Int> {
        var bulls = 0
        var cows = 0

        guess.forEachIndexed { index, digit ->
            if (secret[index] == digit) bulls++
            else if (secret.contains(digit)) cows++
        }

        return Pair(bulls, cows)
    }
}
