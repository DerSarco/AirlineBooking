import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.regular.Regular
import domain.model.baggage.regular.RegularBasic
import domain.model.baggage.regular.RegularClassic
import domain.model.baggage.vclub.ClubBasic
import domain.model.baggage.vclub.ClubClassic
import domain.model.baggage.vclub.Plus
import domain.model.baggage.vclub.VClub
import java.math.BigDecimal

fun main() {
 val basicPrice = BigDecimal(200)
 val classicPrice = BigDecimal(450)
 val plusPrice = BigDecimal(700)

 val basicClub: VClub = ClubBasic(basicPrice)
 val classicClub: VClub = ClubClassic(classicPrice)

 println(basicClub.name)
 println(basicClub.price)

 println()

 println(classicClub.name)
 println(classicClub.price)

 println()

 val basic : Regular = RegularBasic(basicPrice)
 val classic: Regular = RegularClassic(classicPrice)


 println(basic.name)
 println(basic.price)

 println()

 println(classic.name)
 println(classic.price)
 println()

 val plus: BaggagePackage = Plus(plusPrice)

 println(plus.name)
 println(plus.price)

 val vClub: VClub = VClub(basicPrice)

}