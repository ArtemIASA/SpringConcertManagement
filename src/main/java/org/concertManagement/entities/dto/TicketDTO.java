package org.concertManagement.entities.dto;

import org.concertManagement.entities.Ticket;
import org.concertManagement.entities.Visitor;

public class TicketDTO {
    private Visitor visitor;
    private Ticket ticket;

    public TicketDTO() {
    }

    public TicketDTO(Visitor visitor, Ticket ticket){
        this.ticket = ticket;
        this.visitor = visitor;
    }

    public Visitor getVisitor(){
        return visitor;
    }

    public Ticket getTicket(){
        return ticket;
    }
}
