package com.example.kinozippy.model.user;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("customer")
public class Customer extends User {

    // constructors
    public Customer(long id, String username, String password) {
        super(id, username, password);
    }

    public Customer() {
        super();
    }


}
