package org.concertManagement.controllers;


import org.concertManagement.entities.Ticket;
import org.concertManagement.entities.Visitor;
import org.concertManagement.services.ConcertService;
import org.concertManagement.services.FinancesService;
import org.concertManagement.services.TicketService;
import org.concertManagement.services.VisitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("tickets")
public class TicketController {
    private final TicketService ticketService;
    private final VisitorService visitorService;
    private final FinancesService financesService;
    private final ConcertService concertService;

    public TicketController(TicketService ticketService, VisitorService visitorService, FinancesService financesService, ConcertService concertService){
        this.ticketService = ticketService;
        this.visitorService = visitorService;
        this.financesService = financesService;
        this.concertService = concertService;
    }


    @PostMapping
    public ResponseEntity<Void> buyTicket(@RequestBody Ticket ticket){
        Visitor visitor = ticket.getVisitor();
        ticketService.addTicket(ticket);
        visitorService.addVisitor(visitor);
        UUID concertId = concertService.getConcertId(ticket.getConcert());
        int price = ticket.getPrice();
        financesService.changeProfit(concertId, price);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTicket(@RequestBody Ticket ticket){
        Visitor visitor = ticket.getVisitor();
        UUID concertId = concertService.getConcertId(ticket.getConcert());
        ticketService.deleteTicket(ticket);
        visitorService.deleteVisitor(visitor);
        int price = ticket.getPrice();
        financesService.changeProfit(concertId, price);
        return ResponseEntity.ok().build();
    }



}
