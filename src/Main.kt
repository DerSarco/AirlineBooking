import domain.model.*
import domain.model.baggage.vclub.ClubPlus
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import domain.usecases.GetFlights
import domain.usecases.GetTicket
import presentation.flight.FlightHtTMLFormat
import presentation.ticket.TicketConsoleFormat
import presentation.ticket.TicketHTMLFormat
import java.math.BigDecimal

fun main() {
    val getFlights = GetFlights(FlightHtTMLFormat())
    val flights = getFlights.invoke()
    val flight = getFlights.getFlight()
    val getTicket = GetTicket(flight, TicketHTMLFormat())
    val ticket = getTicket.invoke()

    println(flights)
    println()
    println(ticket)

}
