package domain.presentation

//generics
interface Formatter<T> {

    fun format(t: T): String
    fun format(t: List<T>): String {
        val stringBuilder = StringBuilder()
        t.forEach {
            stringBuilder.appendLine(format(it))
        }
        return stringBuilder.toString()
    }
}