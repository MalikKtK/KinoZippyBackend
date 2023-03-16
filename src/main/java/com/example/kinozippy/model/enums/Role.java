package com.example.kinozippy.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Role {
    MANAGER,            // create user accounts define their roles
    SHOP_ASSISTANT,     //
    TICKET_INSPECTOR,   //
    OPERATOR;           //

    // Get
    public static List<Role> getAllRoles() {
        return Arrays.asList(com.example.kinozippy.model.enums.Role.class.getEnumConstants());
    }

}
