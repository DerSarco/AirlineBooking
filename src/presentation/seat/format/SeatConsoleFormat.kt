package presentation.seat.format

import domain.model.seat.Seat
import domain.presentation.Formatter
import presentation.PresentationFormat

class SeatConsoleFormat(): Formatter<Seat>{

    override fun format(t: Seat): String {
        return """
            Seat Number: ${t.number}
            Section: ${t.seatClass.name}
            Price: ${t.price}
        """.trimIndent()
    }
}