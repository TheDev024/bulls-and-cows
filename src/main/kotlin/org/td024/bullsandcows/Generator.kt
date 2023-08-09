package org.td024.bullsandcows

class Generator {

    companion object {

        fun generateSecret(size: Int): String {
            val secretCharArray = System.nanoTime().toString().toSet().toCharArray()
            return if (secretCharArray.size >= size) String(secretCharArray).take(size)
            else generateSecret(size)
        }
    }
}