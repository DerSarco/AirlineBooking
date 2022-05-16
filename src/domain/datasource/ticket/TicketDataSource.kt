package domain.datasource.ticket

import domain.model.Ticket

interface TicketDataSource {
    val tickets : List<Ticket>
}