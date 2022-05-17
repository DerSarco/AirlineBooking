package presentation.reservation

import domain.model.Reservation
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.reservation.format.ReservationConsoleFormat

class ReservationPresentationFactory: PresentationFactory<Reservation> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Reservation> {
        return ReservationConsoleFormat()
    }
}