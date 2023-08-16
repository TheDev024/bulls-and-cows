package org.td024.bullsandcows

class BullsAndCows {
    private val size: Int = IO.getInt(
        "Enter size of the secret code (2-36): ", "Enter a number from given interval!"
    ) { size -> size in 0..10 }
    private val rangeSize: Int = IO.getInt(
        "Enter number of possible characters ($size-36):", "Enter a number from given interval!"
    ) { rangeSize -> rangeSize in size..36 }
    private val charSet: List<Char> = (('0'..'9') + ('a'..'z')).subList(0, rangeSize)
    private val secret: String = Generator.generateSecret(size, charSet)
    private val grader: Grader = Grader()
    private var win: Boolean = false
    private var turn: Int = 1

    private fun guess() {
        val guess = IO.get(
            "Turn $turn:", "Size of the guess must be same with the secret code!"
        ) { guess -> guess.length == size && guess.all { char -> char in charSet } }

        val (bulls, cows) = grader.grade(secret, guess)
        val totalBulls = if (bulls > 0) " $bulls bull(s)" else ""
        val totalCows = if (cows > 0) " $cows cow(s)" else ""
        val none = if (bulls == 0 && cows == 0) " None" else ""

        println("Grade:$totalBulls$totalCows$none.")
        if (bulls == size) win = true else turn++
    }

    fun play() {
        val characterRange = when (rangeSize) {
            in 2 until 10 -> "0-${charSet.last()}"

            10 -> "0-9"

            11 -> "0-9 a"

            in 12 until 36 -> "0-9 a-${charSet.last()}"

            else -> "0-9 a-z"
        }
        println("Secret code generated.\nSize: $size\nCharacter range: $characterRange")
        do {
            guess()
        } while (!win)
        println("Congratulations! You guessed the number in $turn turns")
    }
}
