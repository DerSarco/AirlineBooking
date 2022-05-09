package domain.model

import domain.model.seat.Seat

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val seat: Seat,
    val baggagePackage: BaggagePackage
)
