package domain.model.baggage.regular

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.BoardingTurn
import domain.model.baggage.type.BaggageType
import java.math.BigDecimal

abstract class Regular(
    override var price: BigDecimal
) : BaggagePackage() {
    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn
}