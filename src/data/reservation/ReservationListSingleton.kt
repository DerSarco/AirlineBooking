package data.reservation

import domain.datasource.reservation.ReservationDataSource
import domain.model.Reservation

class ReservationListSingleton: ReservationDataSource {

    companion object {
        private val reservation = Reservation()
    }

    override val reservation: Reservation = ReservationListSingleton.reservation
}