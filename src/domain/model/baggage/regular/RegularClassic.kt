package domain.model.baggage.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularClassic(price: BigDecimal) : Regular(price) {
    override val name: String = "Classic"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
    override var price: BigDecimal = price + BigDecimal(10)
}