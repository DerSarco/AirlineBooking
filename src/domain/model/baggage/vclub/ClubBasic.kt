package domain.model.baggage.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubBasic(price: BigDecimal) : VClub(price) {

    override val name: String = "Basic"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD
}