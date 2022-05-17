package data.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket

class TicketListSingleton: TicketDataSource {

    companion object {
        private val tickets = mutableListOf(
            Ticket()
        )
    }
    override var tickets: List<Ticket> = TicketListSingleton.tickets
}