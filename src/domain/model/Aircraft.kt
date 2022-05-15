package domain.model

import domain.model.seat.SeatSection

data class Aircraft(
    val name: String,
    val model: String,
    val seatSections: List<SeatSection>,
    val airline: Airline = Airline("VL", "Volarios")
)
