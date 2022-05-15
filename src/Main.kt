import domain.model.Flight
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.GetTicket
import presentation.PresentationFormat
import presentation.flight.PresentationFactory
import presentation.ticket.formats.TicketConsoleFormat
import presentation.ticket.formats.TicketHTMLFormat
import java.time.Month

fun main() {

    val flights = GetFlights().invoke(Month.JANUARY)
    val flight = GetFlights().getFlight()
    val getTicket = GetTicket(flight, TicketConsoleFormat())
    val ticket = getTicket.invoke()

    println(flights)
    println()
    println(ticket)

}
