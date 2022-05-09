package domain.model

import domain.model.seat.SeatSection

data class Aircraft(
    val code: String,
    val model: String,
    val airline: Airline,
    val seatSections: Map<Int, SeatSection>
)
