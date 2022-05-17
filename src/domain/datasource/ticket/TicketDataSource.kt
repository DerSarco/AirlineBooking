package domain.datasource.ticket

import domain.model.Ticket

interface TicketDataSource {
    var tickets : List<Ticket>
}