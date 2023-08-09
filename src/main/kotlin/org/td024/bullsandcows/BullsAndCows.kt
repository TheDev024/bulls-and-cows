package org.td024.bullsandcows

class BullsAndCows {
    private val secret: String = random.nextInt(1000, 9999).toString()

    fun guess() {
        val guess = scanner.nextLine()

        val grader = Grader(secret, guess)
        val result = grader.grade()

        println(result)
    }
}
