package domain.datasource.reservation

import domain.model.Reservation

interface ReservationDataSource {
    val reservation : Reservation
}