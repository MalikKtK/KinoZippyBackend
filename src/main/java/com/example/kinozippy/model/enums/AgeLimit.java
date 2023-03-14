package com.example.kinozippy.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum AgeLimit {
    GENERAL_AUDIENCES(1, 0),              // G – General Audiences
    PARENTAL_GUIDANCE_SUGGESTED(2, 7),    // PG – Parental Guidance Suggested
    PARENTS_STRONGLY_CAUTIONED(3, 13),     // PG-13 – Parents Strongly Cautioned
    RESTRICTED(4, 15),                     // R – Restricted
    ADULTS_ONLY(5, 17);                     // NC-17 – Adults Only

    private final int id;
    private final int minimumAge;
    private static final int amountOfAgeLimits = 5;
    // Constructor
    AgeLimit (int id, int minimumAge) {
        this.id = id;
        this.minimumAge = minimumAge;
    }

    // Getter
    public int getId() {
        return id;
    }
    public int getMinimumAge() {
        return minimumAge;
    }


    // Custom made Metoder
    public static List<AgeLimit> getAllAgeLimits() {
        List<AgeLimit> ageLimits = new ArrayList<>();
        for (int i = 1; i <= amountOfAgeLimits; i++) {
            ageLimits.add(getAgeLimit(i));
        }
        return ageLimits;
    }

    private static AgeLimit getAgeLimit(int id) {
        switch (id) {
            case 1 -> {
                return AgeLimit.GENERAL_AUDIENCES;
            }
            case 2 -> {
                return AgeLimit.PARENTAL_GUIDANCE_SUGGESTED;
            }
            case 3 -> {
                return AgeLimit.PARENTS_STRONGLY_CAUTIONED;
            }
            case 4 -> {
                return AgeLimit.RESTRICTED;
            }
            case 5 -> {
                return AgeLimit.ADULTS_ONLY;
            }
            default -> {
                System.err.println("It was not possible to finde the AgeLimit enum using the ID: " + id);
                throw new RuntimeException();
            }
        }
    }
}
