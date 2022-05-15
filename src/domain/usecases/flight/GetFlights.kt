package domain.usecases.flight

import domain.model.Aircraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatSection
import domain.model.seat.SeatStatus
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
        aircraft = Aircraft("Airbus", "A320", seatSections = getSeatSection()),
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


    /**
     * Esta función solo está aqui por que el flight lo necesitaba para una instancia de ticket que se encuentra en
     * Main.
     **/
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

    private fun getSeatSection(): List<SeatSection> {
        val priceEconomy = BigDecimal(100.0)
        val pricePlus = BigDecimal(150.0)
        val priceBusiness = BigDecimal(300.0)
        return listOf(
            SeatSection(SeatClass.ECONOMY, getSeats(SeatClass.ECONOMY, priceEconomy), priceEconomy),
            SeatSection(SeatClass.PLUS, getSeats(SeatClass.PLUS, pricePlus), pricePlus),
            SeatSection(SeatClass.BUSINESS, getSeats(SeatClass.BUSINESS, priceBusiness), priceBusiness),
        )
    }

    private fun getSeats(seatClass: SeatClass, price: BigDecimal): Array<Seat> {
        return arrayOf(
            Seat(
                "1",
                price,
                SeatStatus.AVAILABLE,
                seatClass
            ),    Seat(
                "2",
                price,
                SeatStatus.AVAILABLE,
                seatClass
            ),    Seat(
                "3",
                price,
                SeatStatus.AVAILABLE,
                seatClass
            ),    Seat(
                "4",
                price,
                SeatStatus.AVAILABLE,
                seatClass
            )
        )
    }

}