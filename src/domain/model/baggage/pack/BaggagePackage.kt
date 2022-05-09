package domain.model.baggage.pack

import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BigHand
import domain.model.baggage.type.Checked
import domain.model.baggage.type.Hand
import java.math.BigDecimal

abstract class BaggagePackage {
    abstract val name: String
    abstract val price: BigDecimal
    abstract val boardingTurn: BoardingTurn
    open val baggageTypes: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )

}