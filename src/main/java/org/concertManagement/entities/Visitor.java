package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "visitors")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Visitor(){

    }

    public Visitor(String name, String phoneNumber) {
        this.name = name;
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private static void validatePhoneNumber(String phoneNumber){
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        if (!phoneNumber.matches(regex))
            throw new IllegalArgumentException("Number must match pattern: ddd-ddd-dddd: " + phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber){
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

}
