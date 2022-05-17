package presentation.extFunction

import domain.model.Flight

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotBlank() || this.isNotEmpty()
}

fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun <T> String.isMenuOptionValid(mapObjects: Map<Int, T>): Boolean {
    return if (isNotBlankOrEmpty()) {
        val isValidOption = isNumber() && mapObjects.containsKey(this.toInt())
        return isValidOption
    } else {
        false
    }
}
