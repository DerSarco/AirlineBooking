import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domain.model.Flight
import domain.model.Passenger
import domain.presentation.Formatter
import domain.usecases.baggage.GetBaggagePackage
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackageEnum
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIMenu
import java.time.Month
import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.seat.GetSeatSaved
import domain.usecases.seat.GetSeatsBy
import domain.usecases.seat.GetSeatsSection
import domain.usecases.ticket.AssignBaggagePackToTicket
import domain.usecases.ticket.AssignPassengersToTicket
import domain.usecases.ticket.AssignSeatToTicket
import presentation.baggage.BaggagePackPresentationFactory
import presentation.extFunction.isNumber
import presentation.menu.UIInputData
import presentation.passenger.PassengerPresentationFactory
import presentation.seat.SeatPresentationFactory
import presentation.seat.seatsection.SeatSectionPresentationFactory

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePresentation = BaggagePackPresentationFactory().getPresentationFormat(format)
    val seatPresentation = SeatPresentationFactory().getPresentationFormat(format)
    val seatSectionPresentation = SeatSectionPresentationFactory().getPresentationFormat(format)
    val passengerSectionPresentation = PassengerPresentationFactory().getPresentationFormat(format)


    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)

    val uiMenuFlight = object : UIMenu<Flight> {}

    val flightSelected = uiMenuFlight.showMenu(flightsMap, flightPresentation)

    AssignFlightToTicket(ticketData).invoke(flightSelected)
    val getFlightSaved = GetFlightSaved(ticketData)

    val flightSaved = getFlightSaved()
    println("Flight Selected: ")
    println(
        FlightConsoleFormat().format(flightSaved)
    )


    /**3. Showing baggage packages**/
    //Regular
    //VClub
    val baggagePackageOptions = mapOf(
        1 to BaggagePackageEnum.Regular,
        2 to BaggagePackageEnum.VClub
    )

    val uiMenuBaggagePackOpt = object : UIMenu<BaggagePackageEnum> {}
    val baggagePackageOptSelected =
        uiMenuBaggagePackOpt.showMenu(baggagePackageOptions, object : Formatter<BaggagePackageEnum> {
            override fun format(t: BaggagePackageEnum): String = t.name
        })
    val baggagePackData = when(baggagePackageOptSelected) {
        BaggagePackageEnum.Regular -> BaggageRegularLocalSource()
        BaggagePackageEnum.VClub -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }
    val baggagePacksMap = GetBaggagePackage(baggagePackData).invoke()
    val uiMenuBaggagePack = object : UIMenu<BaggagePackage> {}
    val baggagePackageSelected = uiMenuBaggagePack.showMenu(baggagePacksMap, baggagePresentation)

    /*** 4. Saving Baggage into ticket ***/
    AssignBaggagePackToTicket(ticketData).invoke(baggagePackageSelected)
    val baggagePackSaved = GetBaggageSaved(ticketData).invoke()
    println("Baggage Selected: ")
    println(baggagePresentation.format(baggagePackSaved))

    /** Showing available seats **/

    /**Secciones disponibles**/
    val seatSectionMap = GetSeatsSection(getFlightSaved).invoke()
    val uiSeatsSectionsMenu = object : UIMenu<SeatSection> {}
    val seatSectionSelected = uiSeatsSectionsMenu.showMenu(seatSectionMap, seatSectionPresentation)

    val getSeatsBy = GetSeatsBy()
    val seatsMap = getSeatsBy(seatSectionSelected)

    val uiSeatsMenu = object : UIMenu<Seat> {}
    val seatSelected = uiSeatsMenu.showMenu(seatsMap, seatPresentation)

    /** Save Seat Selected **/
    AssignSeatToTicket(ticketData).invoke(seatSelected)
    val seatSaved = GetSeatSaved(ticketData).invoke()


    println("Seat Saved")
    println(seatPresentation.format(seatSaved))

    /** 7. Introduce information passenger**/
    var passengerQty = ""

    do {
        println("How many passengers are?")
        passengerQty = readLine().orEmpty()
    }while (!passengerQty.isNumber())

    val passengers = (1..passengerQty.toInt()).map {
        println("Passenger: $it")
        val uiInputData = object : UIInputData {}
        val name = uiInputData.requestField("Name")
        val email = uiInputData.requestField("Email")
        val phone = uiInputData.requestField("Phone")
        Passenger(name, email, phone)
    }

    AssignPassengersToTicket(ticketData).invoke(passengers)

    println(
        passengerSectionPresentation.format(passengers)
    )





}
