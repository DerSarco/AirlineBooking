package domain.usecases.baggage

import domain.model.baggage.pack.BaggagePackage

class GetBaggagePackage {

    operator fun invoke(): Map<Int,BaggagePackage>{
        return mapOf()
    }
}