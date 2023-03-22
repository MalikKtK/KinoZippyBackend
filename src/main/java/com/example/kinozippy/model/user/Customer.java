package com.example.kinozippy.model.user;

import com.example.kinozippy.model.Ticket;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private final List<Ticket> tickets = new ArrayList<>();

    // constructors
    public Customer(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Customer() {
    }

    // getter setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
