package domain.usecases.flight

import domain.datasource.ticket.TicketDataSource
import domain.model.Flight


class GetFlightSaved(
    private val ticketDataSource: TicketDataSource
) {

    operator fun invoke(): Flight {
        return ticketDataSource.tickets.first().flight
    }
}