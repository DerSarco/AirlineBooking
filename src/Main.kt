import domain.model.*
import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.vclub.ClubPlus
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {

    val flight = Flight(
        number = "Y4 778",
        aircraft = Aircraft("Airbus", "A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()

    )

    println(flight.format())

    val ticket = Ticket(
        flight,
        passenger = getPassenger(),
        seat = getSeat(),
        baggagePackage = getBaggagePackage()
    )

    println(ticket.format())

}

fun getBaggagePackage(): ClubPlus {
    return ClubPlus(
        price = BigDecimal(300.0)
    )
}

fun getSeat(): Seat {
    return Seat(
        number = "38F",
        price = BigDecimal(150.0),
        seatStatus = SeatStatus.RESERVED,
        seatClass = SeatClass.PLUS
    )

}

fun getPassenger(): Passenger {
    return Passenger(
        name = "Juan Meloso",
        email = "jmeloso@gmail.com",
        phone = "3883727182"
    )

}

fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
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
