package data.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.regular.RegularBasic
import domain.model.baggage.regular.RegularClassic
import domain.model.baggage.regular.RegularPlus

class BaggageRegularLocalSource: BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> = mapOf(
        1 to RegularBasic(price),
        2 to RegularClassic(price),
        3 to RegularPlus(price)
    )
}