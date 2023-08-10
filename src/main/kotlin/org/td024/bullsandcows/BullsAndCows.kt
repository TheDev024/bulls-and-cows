package org.td024.bullsandcows

class BullsAndCows {
    private val size: Int = IO.getInt(
        "Enter size of secret code (0-10): ", "The size must be positive and less than 10!"
    ) { size -> size in 0..10 }
    private val secret: String = Generator.generateSecret(size)
    private val grader: Grader = Grader()
    private var win: Boolean = false
    private var turn: Int = 1

    private fun guess() {
        val guess = IO.get(
            "Turn $turn:", "Size of the guess must be same with the secret code!"
        ) { guess -> guess.length == size }

        val (bulls, cows) = grader.grade(secret, guess)
        val totalBulls = if (bulls > 0) " $bulls bull(s)" else ""
        val totalCows = if (cows > 0) " $cows cow(s)" else ""
        val none = if (bulls == 0 && cows == 0) " None" else ""

        println("Grade:$totalBulls$totalCows$none.")
        if (bulls == size) win = true else turn++
    }

    fun play() {
        println("Try to guess the secret code of size $size!")
        do {
            guess()
        } while (!win)
        println("Congratulations! You guessed the number in $turn turns")
    }
}
