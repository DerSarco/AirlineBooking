package domain.datasource.airport

import domain.model.Airport

interface AirportDataSource {
    fun getAirports() : List<Airport>
}