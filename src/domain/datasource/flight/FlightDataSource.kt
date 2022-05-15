package domain.datasource.flight

import domain.model.Flight

interface FlightDataSource {
    fun getFlights(): Map<Int, Flight>
}