package domain.model.seat

import java.math.BigDecimal

data class Seat(
    val number: String,
    val price: BigDecimal,
    val seatClass: SeatClass,
    val seatStatus: SeatStatus = SeatStatus.AVAILABLE
)
