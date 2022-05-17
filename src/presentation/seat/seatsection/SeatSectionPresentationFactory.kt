package presentation.seat.seatsection

import domain.model.seat.SeatSection
import domain.presentation.Formatter
import presentation.PresentationFormat
import presentation.seat.seatsection.format.SeatSectionConsoleFormat

class SeatSectionPresentationFactory: presentation.PresentationFactory<SeatSection> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<SeatSection> {
        return SeatSectionConsoleFormat()
    }
}