package domain.usecases.reservation

import data.reservation.ReservationListSingleton
import domain.model.Reservation

class GetReservation(
    private val reservationListSingleton: ReservationListSingleton
) {
    operator fun invoke(): Reservation {
        return reservationListSingleton.reservation
    }
}