package presentation.flight

import domain.model.Flight
import domain.presentation.Formatter
import presentation.PresentationFormat
import presentation.flight.formats.FlightConsoleFormat

class FlightPresentationFactory: presentation.PresentationFactory<Flight> {

    override fun getPresentationFormat(format: PresentationFormat): Formatter<Flight> {
        return when (format) {
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightConsoleFormat()
            else -> FlightConsoleFormat()
        }
    }
}