package domain.usecases.ticket.di

import data.ticket.TicketListSingleton
import domain.datasource.ticket.TicketDataSource

class TicketDataDI {

    fun providesTicketsData(): TicketDataSource{
        return TicketListSingleton()
    }
}