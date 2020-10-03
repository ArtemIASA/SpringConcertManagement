package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "concert_id")
    private Concert concert;

    @Column(name = "price")
    private int price;

    public Visitor getVisitor() {
        return visitor;
    }

    public Ticket(){

    }

    public Ticket(Visitor visitor, Concert concert, int price){
        this.visitor = visitor;
        this.concert = concert;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Concert getConcert() {
        return concert;
    }
}