package domain.model.baggage.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Plus(price: BigDecimal) : VClub(price) {
    override val name: String = "Plus VClub"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST

}