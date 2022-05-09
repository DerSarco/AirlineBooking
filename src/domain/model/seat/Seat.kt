package domain.model.seat

import java.math.BigDecimal

data class Seat(
    val number: String,
    val price: BigDecimal,
    val seatStatus: SeatStatus,
    val seatClass: SeatClass
)
