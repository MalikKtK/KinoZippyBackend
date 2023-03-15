package com.example.kinozippy.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    ACTION,
    ADVENTURE,
    ANIMATION,
    BIOGRAPHY,
    COMEDY,
    CRIME,
    DOCUMENTARY,
    DRAMA,
    FAMILY,
    FANTASY,
    HISTORY;




    // Custom made Metoder
    public static List<Category> getAllCategories() {
        return Arrays.asList(Category.class.getEnumConstants());
    }



}
