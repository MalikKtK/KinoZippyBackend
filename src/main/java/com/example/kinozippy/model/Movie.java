package com.example.kinozippy.model;

import com.example.kinozippy.model.enums.AgeLimit;
import jakarta.persistence.Id;

public class Movie {

    @Id
    private int id;
    private String title;
    private String category;
    private AgeLimit ageLimit;

}
