package data.airport

import domain.datasource.airport.AirportDataSource
import domain.model.Airport

class AirportLocalDataSource: AirportDataSource {
    override fun getAirports(): List<Airport>  = listOf(
        Airport("QXM", "Mexico City"),
        Airport("CHI", "Chicago"),
        Airport("BOG", "Bogotá"),
        Airport("CUN", "Cancún")
    )
}