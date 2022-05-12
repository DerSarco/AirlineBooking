package domain.model

import domain.presentation.Formatter
import java.math.BigDecimal
import java.time.Duration
import java.time.format.DateTimeFormatter

data class Flight(
    val number: String,
    val aircraft: Aircraft,
    val price: BigDecimal,
    val departureArrivalBooking: Pair<AirportBooking, AirportBooking>,
    val duration: Duration = Duration.between(
        departureArrivalBooking.second.dateTime,
        departureArrivalBooking.first.dateTime
    )
) : Formatter {
    override fun format(): String {
        val departure = departureArrivalBooking.first
        val arrival = departureArrivalBooking.second

        return """
            $number
            Origin: ${departure.airport.name}
            Origin DateTime: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival DateTime: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: $duration
            Price: $${price}
            
        """.trimIndent()
    }
}
