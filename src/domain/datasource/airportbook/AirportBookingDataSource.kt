package domain.datasource.airportbook

import domain.model.AirportBooking

interface AirportBookingDataSource {
    fun getAirBookingPairs(): List<Pair<AirportBooking, AirportBooking>>

}