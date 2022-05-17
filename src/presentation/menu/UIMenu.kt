package presentation.menu

import domain.presentation.Formatter
import presentation.extFunction.isMenuOptionValid
import presentation.flight.formats.FlightConsoleFormat


interface UIMenu<T> {

    fun showMenu(
        mapObjects: Map<Int, T>,
        formatter: Formatter<T>
    ): T? {
        var optionSelected = ""
        do {
            //Mostrando la lista de Flights
            mapObjects.forEach { (t, u) ->
                print("$t. ")
                println(formatter.format(u))
            }

            println("*** Select Number Option ***")
            optionSelected = readLine().orEmpty()
            val isNumber = optionSelected.all {
                it.isDigit()
            }
        } while (!optionSelected.isMenuOptionValid(mapObjects))

        return mapObjects[optionSelected.toInt()]
    }
}