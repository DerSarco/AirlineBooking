package domain.usecases.flight

import domain.datasource.flight.FlightDataSource
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

class GetFlights(
    private val flightDataSource: FlightDataSource
) {

    fun invoke(month: Month): Map<Int, Flight> {
        return flightDataSource.getFlights().filter { flightEntry ->
            flightEntry.value.departureArrivalBooking.first.dateTime.month == month
        }
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
                seatClass
            ),    Seat(
                "2",
                price,
                seatClass
            ),    Seat(
                "3",
                price,
                seatClass
            ),    Seat(
                "4",
                price,
                seatClass
            )
        )
    }

}