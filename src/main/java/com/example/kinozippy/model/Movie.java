package com.example.kinozippy.model;

import com.example.kinozippy.model.enums.AgeLimit;
import com.example.kinozippy.model.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    private int id;
    private String title;
    private Category category;
    private AgeLimit ageLimit;

    // constructors



    // getters setters

}
