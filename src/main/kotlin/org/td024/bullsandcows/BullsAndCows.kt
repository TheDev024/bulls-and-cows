package org.td024.bullsandcows

class BullsAndCows {
    private val secret: String

    init {
        val size = IO.getInt(
            "Enter size for secret code (less than 10):", "Number must be less than 10 and positive!", 0..10
        )
        this.secret = Generator.generateSecret(size)
    }

    fun guess() {
        val guess = IO.getLine("Make a guess:")

        val grader = Grader(secret, guess)
        val result = grader.grade()

        println(result)
    }
}
