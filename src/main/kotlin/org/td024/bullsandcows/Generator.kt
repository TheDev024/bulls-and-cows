package org.td024.bullsandcows

class Generator {

    companion object {

        fun generateSecret(size: Int, charSet: List<Char>): String {
            val secretCharArray = CharArray(size) {
                charSet.random()
            }.toSet().toCharArray()
            return if (secretCharArray.size == size) String(secretCharArray)
            else generateSecret(size, charSet)
        }
    }
}