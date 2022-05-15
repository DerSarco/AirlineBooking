import domain.usecases.GetFlights
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightHtTMLFormat

fun main() {
    val getFlights = GetFlights(FlightHtTMLFormat())
    val flightFormat = getFlights.invoke()
    println(flightFormat)

}