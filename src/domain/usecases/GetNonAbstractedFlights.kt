package domain.usecases

import domain.model.Aircraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import presentation.PresentationFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

//ESTO ES LO QUE NO SE DEBED HACER
class GetNonAbstractedFlights(
    val format: PresentationFormat
) {

    fun invoke(): String {

        val t = Flight(
            number = "Y4 778",
            aircraft = Aircraft("Airbus", "A320"),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )

        return when (format) {
            PresentationFormat.CONSOLE -> {
                val departure = t.departureArrivalBooking.first
                val arrival = t.departureArrivalBooking.second
                """
                    ${t.number}
                    Origin: ${departure.airport.name}
                    Origin DateTime: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                    Arrival: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                    Arrival DateTime: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                    Duration: ${t.duration}
                    Price: $${t.price}

                 """.trimIndent()
            }
            PresentationFormat.HTML -> {
                val departure = t.departureArrivalBooking.first
                val arrival = t.departureArrivalBooking.second

                """
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
            PresentationFormat.JSON -> {
                """
                    flight: {}
                """.trimIndent()
            }
        }
    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogotá"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 13, 0, 0)
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancún"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 17, 30, 0)
            )
        )
    }
}