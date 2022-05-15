package presentation.flight.formats

import domain.model.Flight
import domain.presentation.Formatter
import java.time.format.DateTimeFormatter


class FlightHtTMLFormat: Formatter<Flight> {

    override fun format(t: Flight): String {
        val departure = t.departureArrivalBooking.first
        val arrival = t.departureArrivalBooking.second

        return """
            <p>            
            <strong>${t.number}</strong></br>
            Origin: ${departure.airport.name}</br>
            Destination: ${arrival.airport.name}</br>
            Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}</br>
            Arrival date${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}</br>
            Duration: ${t.duration}</br>
            <strong>Price: $${t.price}</strong>
            </p>
            
        """.trimIndent()

    }

}