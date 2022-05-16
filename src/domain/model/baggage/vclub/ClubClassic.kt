package domain.model.baggage.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubClassic(price: BigDecimal) : VClub(price) {
    override val name: String = "Club Classic"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND

    override var price: BigDecimal = price
        get()  {
            return super.price + BigDecimal(10)
        }
}
