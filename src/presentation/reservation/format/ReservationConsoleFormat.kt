package presentation.reservation.format

import domain.model.Reservation
import domain.presentation.Formatter

class ReservationConsoleFormat: Formatter<Reservation> {
    override fun format(t: Reservation): String {
        return """
            ${t.code}
            ${t.total}
        """.trimIndent()
    }
}