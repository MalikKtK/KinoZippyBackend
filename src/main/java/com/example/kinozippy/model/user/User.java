package com.example.kinozippy.model.user;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String password;
    @NonNull
    private String username;

    @Override
    public String toString() {
        return String.format("id: %s, username: %s", id, username);
    }

    // constructors
    public User(int id, String password, @NonNull String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public User() {
    }

    // getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }
}
