package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lessees")
public class Lessee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    public Lessee(){

    }

    public Lessee(String name, String phoneNumber, String email){
        this.name = name;
        validatePhoneNumber(phoneNumber);
        validateEmail(email);
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    private static void validateEmail(String email){
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        if (!email.matches(regex))
            throw new IllegalArgumentException("Email must match pattern: " +
                    "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]: " + email);
    }

    public void setEmail(String email){
        validateEmail(email);
        this.email = email;
    }
}
