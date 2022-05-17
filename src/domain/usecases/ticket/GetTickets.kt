package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket

class GetTickets(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(): List<Ticket> {
        return ticketDataSource.tickets
    }
}