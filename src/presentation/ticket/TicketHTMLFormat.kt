package presentation.ticket

import domain.model.Ticket
import domain.presentation.Formatter

class TicketHTMLFormat : Formatter<Ticket> {
    override fun format(t: Ticket): String {
        return """
           <p>
           <strong>Flight Number: ${t.flight.number}</strong></br>
           Flight Aircraft: ${t.flight.aircraft.name} - ${t.flight.aircraft.model}</br>
           Airline: ${t.flight.aircraft.airline.name}</br>
           Seat: ${t.seat.number}</br>
           Seat Class: ${t.seat.seatClass.name}</br>
           Boarding Turn: ${t.seat.seatClass.ordinal}</br>
           <strong>Total Price: ${t.totalPrice}</strong>
           </p>
        """.trimIndent()
    }
}