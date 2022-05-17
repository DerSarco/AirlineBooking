package presentation.menu

import presentation.extFunction.isBlankOrEmpty

interface UIInputData {

    fun requestField(fieldName: String): String {
        var field = ""
        do {
            println("Introduce your $fieldName")
            field = readLine().orEmpty()
        } while (field.isBlankOrEmpty())
        return field
    }
}