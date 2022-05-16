import data.aircraft.AircraftLocalDataSource
import data.airport.AirportLocalDataSource
import data.airportbook.AirportBookingLocalSource
import data.baggage.BaggageVClubLocalSource
import data.flight.FlightLocalDataSource
import data.ticket.TicketListSingleton
import domain.datasource.aircraft.AircraftDataSource
import domain.datasource.ticket.TicketDataSource
import domain.model.Flight
import domain.model.Ticket
import domain.usecases.baggage.GetBaggagePackage
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.GetTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.flight.PresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.ticket.formats.TicketConsoleFormat
import presentation.ticket.formats.TicketHTMLFormat
import java.time.Month

fun main() {

    val ticketData = TicketDataDI().providesTicketsData()

    val getFlights = GetFlights(FlightDataDI().providesFlightsData()).invoke(Month.JANUARY)

    getFlights.forEach{ (t ,u) ->
        print("$t. ")
        println(FlightConsoleFormat().format(u))
    }

    println("*** Flight Selected ***")

    val flight = getFlights[1]
    AssignFlightToTicket(ticketData).invoke(flight)
    val flightSelected = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSelected)
    )

}
