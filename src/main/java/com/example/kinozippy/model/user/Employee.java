package com.example.kinozippy.model.user;

import com.example.kinozippy.model.enums.Role;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User {

    private Role role;

    // constructors
    public Employee(int id, String username, String password, Role role) {
        super(id, username, password);
        this.role = role;
    }

    public Employee() {
    }

    // getter setter
    @NonNull
    public Role getRole() {
        return role;
    }

    public void setRole(@NonNull Role role) {
        this.role = role;
    }

}
