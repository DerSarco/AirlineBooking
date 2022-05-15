package data.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.vclub.ClubBasic
import domain.model.baggage.vclub.ClubClassic
import domain.model.baggage.vclub.ClubPlus

class BaggageRegularLocalSource: BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> = mapOf(
        1 to ClubBasic(price),
        2 to ClubClassic(price),
        3 to ClubPlus(price)
    )
}