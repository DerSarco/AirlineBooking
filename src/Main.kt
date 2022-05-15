import domain.model.*
import domain.model.baggage.vclub.ClubPlus
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import domain.usecases.GetFlights
import domain.usecases.GetTicket
import presentation.PresentationFormat
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightHtTMLFormat
import presentation.flight.FlightPresentationFactory
import presentation.ticket.TicketConsoleFormat
import presentation.ticket.TicketHTMLFormat
import java.math.BigDecimal

fun main() {

    val format = PresentationFormat.CONSOLE
    val flightFormat = FlightPresentationFactory().getPresentationFormat(format)
    val flights = GetFlights(flightFormat).invoke()
    val flight = GetFlights(flightFormat).getFlight()
    val getTicket = GetTicket(flight, TicketHTMLFormat())
    val ticket = getTicket.invoke()

    println(flights)
    println()
    println(ticket)

}
