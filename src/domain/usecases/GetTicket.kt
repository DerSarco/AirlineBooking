package domain.usecases

import domain.model.Flight
import domain.model.Passenger
import domain.model.Ticket
import domain.model.baggage.vclub.ClubPlus
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import domain.presentation.Formatter
import java.math.BigDecimal

class GetTicket(
    private val flight: Flight,
    private val formatter: Formatter<Ticket>
) {

    fun invoke(): String{
        val ticket = Ticket(
            flight,
            passenger = getPassenger(),
            seat = getSeat(),
            baggagePackage = getBaggagePackage()
        )

        return formatter.format(ticket)
    }

    private fun getBaggagePackage(): ClubPlus {
        return ClubPlus(
            price = BigDecimal(300.0)
        )
    }

    private fun getSeat(): Seat {
        return Seat(
            number = "38F",
            price = BigDecimal(150.0),
            seatStatus = SeatStatus.RESERVED,
            seatClass = SeatClass.PLUS
        )

    }

    private fun getPassenger(): Passenger {
        return Passenger(
            name = "Juan Meloso",
            email = "jmeloso@gmail.com",
            phone = "3883727182"
        )

    }
}