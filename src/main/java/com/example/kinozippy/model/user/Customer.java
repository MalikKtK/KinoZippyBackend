package com.example.kinozippy.model.user;

import com.example.kinozippy.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

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
