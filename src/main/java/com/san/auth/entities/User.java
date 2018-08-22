package com.san.auth.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
public class User {
    /**
     * Default constructor for JPA usage.
     */
    public User() {
    }

    public User(String userName, String email, String password, LocalDateTime registrationDateTime) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDateTime = registrationDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
}
