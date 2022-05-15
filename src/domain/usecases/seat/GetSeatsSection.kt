package domain.usecases.seat

import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.usecases.flight.GetFlightSaved

/**
 *  5. Mostrar los asientos disponibles
 **/
class GetSeatsSection(
    private val getFlightSaved: GetFlightSaved
) {
    operator fun invoke(): Map<Int, SeatSection> {
        val flight = getFlightSaved()
        return flight.aircraft.seatSections.mapIndexed { index, seatSection ->
            index + 1 to seatSection
        }.toMap()
    }
}