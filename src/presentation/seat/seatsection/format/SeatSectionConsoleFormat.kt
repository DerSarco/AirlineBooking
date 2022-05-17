package presentation.seat.seatsection.format

import domain.model.seat.SeatSection
import domain.presentation.Formatter

class SeatSectionConsoleFormat: Formatter<SeatSection> {
    override fun format(t: SeatSection): String {
        return """
            Section Name: ${t.seatClass.name}
            Number of seats: ${t.seats}
            Section Price : ${t.price}
        """.trimIndent()
    }
}