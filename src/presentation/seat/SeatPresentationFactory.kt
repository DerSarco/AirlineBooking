package presentation.seat

import domain.model.seat.Seat
import domain.presentation.Formatter
import presentation.PresentationFormat
import presentation.seat.format.SeatConsoleFormat

class SeatPresentationFactory: presentation.PresentationFactory<Seat> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Seat> {
        return SeatConsoleFormat()
    }
}