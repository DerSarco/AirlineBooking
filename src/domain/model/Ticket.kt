package domain.model

import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.presentation.Formatter
import java.math.BigDecimal

class Ticket {
    lateinit var flight: Flight
    lateinit var passenger: Passenger
    lateinit var seat: Seat
    lateinit var baggagePackage: BaggagePackage
    val totalPrice: BigDecimal //=
        get() {
            return if (this::flight.isInitialized && this::baggagePackage.isInitialized && this::seat.isInitialized)
                flight.price + baggagePackage.price + seat.price
            else
                BigDecimal(0)
        }
}
