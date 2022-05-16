package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Passenger
import domain.model.Ticket

/**
 *  7. Introducir información del pasajero
 **/

class AssignPassengerToTicket(
    private val ticketDataSource: TicketDataSource
) {

    operator fun invoke(passenger: Passenger?): Ticket? {
        return passenger?.let {
            ticketDataSource.tickets.first().apply {
                this.passenger = it
            }
        }
    }
}