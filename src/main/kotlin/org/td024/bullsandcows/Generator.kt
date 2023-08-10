package org.td024.bullsandcows

class Generator {

    companion object {

        fun generateSecret(size: Int): String {
            val secretCharArray = CharArray(size) { ('0'..'9').random() }.toSet().toCharArray()
            return if (secretCharArray.size >= size) String(secretCharArray).takeLast(size)
            else generateSecret(size)
        }
    }
}