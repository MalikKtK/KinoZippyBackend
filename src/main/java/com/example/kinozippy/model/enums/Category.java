package com.example.kinozippy.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    ACTION(1),
    ADVENTURE(2),
    ANIMATION(3),
    BIOGRAPHY(4),
    COMEDY(5),
    CRIME(6),
    DOCUMENTARY(7),
    DRAMA(8),
    FAMILY(9),
    FANTASY(10),
    HISTORY(11);

    private final int id;
    private static final int amountOfCategories = 11;

    // Constructor
    Category (int id) {
        this.id = id;
    }

    // Getter
    public int getId() {
        return id;
    }


    // Custom made Metoder
    public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= amountOfCategories; i++) {
            categories.add(getCategory(i));
        }
        return categories;
    }

    private static Category getCategory(int id) {
        switch (id) {
            case 1 -> {
                return Category.ACTION;
            }
            case 2 -> {
                return Category.ADVENTURE;
            }
            case 3 -> {
                return Category.ANIMATION;
            }
            case 4 -> {
                return Category.BIOGRAPHY;
            }
            case 5 -> {
                return Category.COMEDY;
            }
            case 6 -> {
                return Category.CRIME;
            }
            case 7 -> {
                return Category.DOCUMENTARY;
            }
            case 8 -> {
                return Category.DRAMA;
            }
            case 9 -> {
                return Category.FAMILY;
            }
            case 10 -> {
                return Category.FANTASY;
            }
            case 11 -> {
                return Category.HISTORY;
            }
            default -> {
                System.err.println("It was not possible to finde the Category enum using the ID: " + id);
                throw new RuntimeException();
            }
        }
    }



}
