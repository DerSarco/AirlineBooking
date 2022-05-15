package presentation.ticket

import domain.model.Ticket
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.ticket.formats.TicketConsoleFormat
import presentation.ticket.formats.TicketHTMLFormat

class TicketPresentationFactory: PresentationFactory<Ticket> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Ticket> {
        return when(format){
            PresentationFormat.CONSOLE -> TicketConsoleFormat()
            PresentationFormat.HTML -> TicketHTMLFormat()
            else -> TicketConsoleFormat()
        }
    }
}