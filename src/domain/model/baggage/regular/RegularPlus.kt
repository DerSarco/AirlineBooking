package domain.model.baggage.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularPlus(price: BigDecimal) : Regular(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}