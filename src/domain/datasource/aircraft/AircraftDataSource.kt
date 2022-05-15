package domain.datasource.aircraft

import domain.model.Aircraft

interface AircraftDataSource {
    fun getAirCrafts(): List<Aircraft>
}