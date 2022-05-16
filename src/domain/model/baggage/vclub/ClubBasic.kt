package domain.model.baggage.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubBasic(price: BigDecimal) : VClub(price) {

    override val name: String = "Club Basic"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD

    override var price: BigDecimal = price
        get() {
            return super.price
        }
}