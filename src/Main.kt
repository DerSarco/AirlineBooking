import data.aircraft.AircraftLocalDataSource
import data.airport.AirportLocalDataSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalDataSource
import domain.datasource.aircraft.AircraftDataSource
import domain.model.Flight
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.GetTicket
import presentation.PresentationFormat
import presentation.flight.PresentationFactory
import presentation.ticket.formats.TicketConsoleFormat
import presentation.ticket.formats.TicketHTMLFormat
import java.time.Month

fun main() {

    val aircraftLocalDataSource = AircraftLocalDataSource()
    val airportLocalDataSource = AirportLocalDataSource()
    val airBookingLocalDataSource = AirportBookingLocalSource(airportLocalDataSource)
    val flightLocalDataSource = FlightLocalDataSource(
        aircraftLocalDataSource,
        airBookingLocalDataSource
    )

    val flights = GetFlights(flightLocalDataSource).invoke(Month.JANUARY)

    println(flights)

}
