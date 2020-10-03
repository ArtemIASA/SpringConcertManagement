package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "arenas")
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private int capacity;

    public Arena(){

    }

    public Arena(String name, String address, int capacity){
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }
}
