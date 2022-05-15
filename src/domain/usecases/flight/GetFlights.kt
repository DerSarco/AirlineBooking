package domain.usecases.flight

import domain.model.Aircraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import domain.presentation.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

/**
 *  1. Mostrar los vuelos disponibles de un mes
 **/

class GetFlights {

    private val flight = Flight(
        number = "Y4 778",
        aircraft = Aircraft("Airbus", "A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()

    )

    fun invoke(month: Month): Map<Int, Flight> {

        val flightsMap = mapOf(
            1 to flight,
            2 to flight,
            3 to flight,
        )

        return flightsMap.filter { flightEntry ->
            flightEntry.value.departureArrivalBooking.first.dateTime.month == month
        }

    }

    fun getFlight(): Flight {
        return flight
    }


    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogotá"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 13, 0, 0)
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancún"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 17, 30, 0)
            )
        )
    }

}