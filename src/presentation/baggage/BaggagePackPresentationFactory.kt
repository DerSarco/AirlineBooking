package presentation.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.presentation.Formatter
import presentation.PresentationFormat
import presentation.baggage.format.BaggagePackageConsole
import presentation.baggage.type.format.BaggageTypeConsole

class BaggagePackPresentationFactory: presentation.PresentationFactory<BaggagePackage> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<BaggagePackage> {
        return BaggagePackageConsole(BaggageTypeConsole())
    }
}