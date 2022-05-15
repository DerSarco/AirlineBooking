package domain.model

import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.presentation.Formatter
import java.math.BigDecimal

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val seat: Seat,
    val baggagePackage: BaggagePackage,
    val totalPrice: BigDecimal = flight.price + baggagePackage.price + seat.price
)
