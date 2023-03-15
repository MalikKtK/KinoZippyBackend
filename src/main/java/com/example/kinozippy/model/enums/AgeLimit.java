package com.example.kinozippy.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AgeLimit {
    GENERAL_AUDIENCES(0),              // G – General Audiences
    PARENTAL_GUIDANCE_SUGGESTED(7),    // PG – Parental Guidance Suggested
    PARENTS_STRONGLY_CAUTIONED(13),     // PG-13 – Parents Strongly Cautioned
    RESTRICTED(15),                     // R – Restricted
    ADULTS_ONLY(17);                     // NC-17 – Adults Only


    private final int minimumAge;
    // Constructor
    AgeLimit (int minimumAge) {
        this.minimumAge = minimumAge;
    }

    // Getter
    public int getMinimumAge() {
        return minimumAge;
    }


    // Custom made Metoder
    public static List<AgeLimit> getAllAgeLimits() {
        return Arrays.asList(AgeLimit.class.getEnumConstants());
    }
}
