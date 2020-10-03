package org.concertManagement.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "arena_id")
    private Arena arena;

    @Column(name = "date")
    private Date date;


    public Concert(){

    }

    public Concert(String name, String type, Arena arena, Date date) {
        this.name = name;
        this.type = type;
        this.arena = arena;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
