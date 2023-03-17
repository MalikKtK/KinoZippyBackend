package com.example.kinozippy.model;

import com.example.kinozippy.model.enums.AgeLimit;
import com.example.kinozippy.model.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "title")
    @NonNull
    @JsonProperty("title")
    private String title;

    @Column(name = "age_limit")
    @NonNull
    @JsonProperty("ageLimit")
    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;

    @Column(name = "category")
    @NonNull
    @JsonProperty("category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "length_in_minutes")
    @NonNull
    @JsonProperty("length")
    private int lengthInMinutes;

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<ShowTime> showTimes;


    @Column(name = "rating", length = 10)
    @JsonProperty("rating")
    @NonNull
    private int rating;

    // ### constructors ###
    public Movie(long id, String title, AgeLimit ageLimit, Category category, int lengthInMinutes, List<ShowTime> showTimes, int rating) {
        this.id = id;
        this.title = title;
        this.ageLimit = ageLimit;
        this.category = category;
        this.lengthInMinutes = lengthInMinutes;
        this.showTimes = showTimes;
        this.rating = rating;
    }

    public Movie(String title, AgeLimit ageLimit, Category category, int lengthInMinutes) {
        this.title = title;
        this.ageLimit = ageLimit;
        this.category = category;
        this.lengthInMinutes = lengthInMinutes;
    }

    public Movie() {
    }

    // ### getters setters ###
    public Long getId() {
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

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
