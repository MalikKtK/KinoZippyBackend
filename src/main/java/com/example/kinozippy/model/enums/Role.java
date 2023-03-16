package com.example.kinozippy.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Role {
    MANAGER("Admin"),            // create user accounts define their roles
    SHOP_ASSISTANT ("Staff"),     //
    TICKET_INSPECTOR("Staff"),   //
    OPERATOR("Staff");           //

    private final String startRole;
    // Constructor
    Role (String startRole) {
        this.startRole = startRole;
    }

    // Getter
    public String getStartRole() {
        return startRole;
    }
    public static List<Role> getAllRoles() {
        return Arrays.asList(com.example.kinozippy.model.enums.Role.class.getEnumConstants());
    }

}
