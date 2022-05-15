package data.baggage

import domain.datasource.baggage.BaggagePackageDataSource
import domain.model.baggage.pack.BaggagePackage
import java.math.BigDecimal

abstract class BaggagePackageLocalSource: BaggagePackageDataSource {
    val price : BigDecimal = BigDecimal(50)
}