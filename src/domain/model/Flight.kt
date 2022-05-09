package domain.model

import java.math.BigDecimal
import java.time.Duration

data class Flight(
    val number: String,
    val aircraft: Aircraft,
    val price: BigDecimal,
    val duration: Duration,
    val DepartureArrivalBooking: Pair<AirportBooking, AirportBooking>
)
