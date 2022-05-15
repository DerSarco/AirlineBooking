package presentation

import domain.model.Ticket
import domain.presentation.Formatter

class TicketConsoleFormat: Formatter<Ticket> {
    override fun format(t: Ticket): String {
        return """
           Flight Number: ${t.flight.number}
           Flight Aircraft: ${t.flight.aircraft.name} - ${t.flight.aircraft.model}
           Airline: ${t.flight.aircraft.airline.name}
           Seat: ${t.seat.number}
           Seat Class: ${t.seat.seatClass.name}
           Boarding Turn: ${t.seat.seatClass.ordinal}
           Total Price: ${t.totalPrice}
        """.trimIndent()
    }
}