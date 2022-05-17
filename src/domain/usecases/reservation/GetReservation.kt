package domain.usecases.reservation

import data.reservation.ReservationListSingleton
import domain.datasource.reservation.ReservationDataSource
import domain.datasource.ticket.TicketDataSource
import domain.model.Reservation

class GetReservation(
    private val reservationDataSource: ReservationDataSource
) {
    operator fun invoke(): Reservation {
        return reservationDataSource.reservation
    }
}