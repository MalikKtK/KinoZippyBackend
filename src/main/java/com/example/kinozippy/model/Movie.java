package com.example.kinozippy.model;

import com.example.kinozippy.model.enums.AgeLimit;
import com.example.kinozippy.model.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Movie {
    @Id
    private long id;
    @NonNull
    private String title;
    @NonNull
    private Category category;
    @NonNull
    private AgeLimit ageLimit;

    // constructors
    public Movie(long id, String title, Category category, AgeLimit ageLimit) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.ageLimit = ageLimit;
    }

    public Movie() {
    }

    // getters setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }
}
