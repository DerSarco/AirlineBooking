package presentation.baggage.type.format

import domain.model.baggage.type.BaggageType
import domain.presentation.Formatter

class BaggageTypeConsole: Formatter<BaggageType> {
    override fun format(t: BaggageType): String {
        return """
${t.emoji} - ${t.title} - ${t.description}
        """.trimIndent()
    }
}