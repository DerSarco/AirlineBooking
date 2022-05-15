package presentation.flight

import domain.model.Flight
import domain.presentation.Formatter
import presentation.PresentationFormat
import java.util.EventListener

class FlightPresentationFactory {

    fun getPresentationFormat(format: PresentationFormat): Formatter<Flight>{
        return when(format){
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightHtTMLFormat()
            else -> FlightConsoleFormat()
        }
    }
}