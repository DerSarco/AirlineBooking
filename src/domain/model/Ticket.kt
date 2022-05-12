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
) : Formatter {

    override fun format(): String {
        return """
           Flight Number: ${flight.number}
           Flight Aircraft: ${flight.aircraft.name} - ${flight.aircraft.model}
           Airline: ${flight.aircraft.airline.name}
           Seat: ${seat.number}
           Seat Class: ${seat.seatClass.name}
           Boarding Turn: ${seat.seatClass.ordinal}
           Total Price: $totalPrice
        """.trimIndent()
    }
}
