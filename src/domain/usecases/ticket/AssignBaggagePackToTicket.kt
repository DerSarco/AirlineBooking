package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage

/**
 *  4. Seleccionar un equipaje
 **/
class AssignBaggagePackToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(baggagePackage: BaggagePackage?): Ticket? {
        return baggagePackage?.let {
            ticketDataSource.tickets.first().apply {
                this.baggagePackage = it
            }
        }
    }
}