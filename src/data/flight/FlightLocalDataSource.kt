package data.flight

import domain.datasource.aircraft.AircraftDataSource
import domain.datasource.airportbook.AirportBookingDataSource
import domain.datasource.flight.FlightDataSource
import domain.model.Flight
import java.math.BigDecimal

class FlightLocalDataSource(
    private val aircraftDataSource: AircraftDataSource,
    private val airportBookingDataSource: AirportBookingDataSource
): FlightDataSource {
    override fun getFlights(): Map<Int, Flight> = mapOf(
        1 to Flight(
            number = "Y4 708",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(100.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random(),
        ),
        2 to Flight(
            number = "Y4 905",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(130.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        3 to Flight(
            number = "Y4 748",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(110.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        4 to Flight(
            number = "Y4 819",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(100.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        5 to Flight(
            number = "Y4 5478",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(90.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        6 to Flight(
            number = "Y4 901",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(90.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        7 to Flight(
            number = "Y4 858",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(150.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        8 to Flight(
            number = "Y4 806",
            aircraft = aircraftDataSource.getAirCrafts().random(),
            price = BigDecimal(60.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        )
    )
}