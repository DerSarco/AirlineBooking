package domain.usecases.flight.di

import data.aircraft.AircraftLocalDataSource
import data.airport.AirportLocalDataSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalDataSource
import domain.datasource.flight.FlightDataSource

class FlightDataDI {

    fun providesFlightsData(): FlightDataSource {
        val airportLocalDataSource = AirportLocalDataSource()
        val airBookingLocalDataSource = AirportBookingLocalSource(airportLocalDataSource)
        val aircraftLocalDataSource = AircraftLocalDataSource()
        return FlightLocalDataSource(aircraftLocalDataSource, airBookingLocalDataSource)
    }
}