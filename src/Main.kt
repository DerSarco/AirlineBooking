import domain.model.Flight
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.GetTicket
import presentation.PresentationFormat
import presentation.flight.PresentationFactory
import presentation.ticket.formats.TicketHTMLFormat

fun main() {

    val format = PresentationFormat.CONSOLE
    val flightFormat = PresentationFactory().getPresentationFormat(format, Flight::class)
    val flights = GetFlights(flightFormat).invoke()
    val flight = GetFlights(flightFormat).getFlight()
    val getTicket = GetTicket(flight, TicketHTMLFormat())
    val ticket = getTicket.invoke()

    println(flights)
    println()
    println(ticket)

}
