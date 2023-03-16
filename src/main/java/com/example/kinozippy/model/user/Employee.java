package com.example.kinozippy.model.user;

import com.example.kinozippy.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User {


    @Column(name = "role")
    @NonNull
    @JsonProperty("role")
    private Role role;

    // constructors
    public Employee(long id, String username, String password, Role role) {
        super(id, username, password);
        this.role = role;
    }

    public Employee() {
        super();
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Role getRole() {
        return role;
    }

}
