package presentation.passenger

import domain.model.Passenger
import domain.presentation.Formatter
import presentation.PresentationFormat
import presentation.passenger.format.PassengerConsoleFormat

class PassengerPresentationFactory: presentation.PresentationFactory<Passenger> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Passenger> {
        return PassengerConsoleFormat()
    }
}