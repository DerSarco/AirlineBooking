package domain.usecases.seat

import domain.datasource.ticket.TicketDataSource
import domain.model.seat.Seat

class GetSeatSaved(
    private val ticketData: TicketDataSource
) {

    operator fun invoke(): Seat {
        return ticketData.tickets.first().seat
    }

}
