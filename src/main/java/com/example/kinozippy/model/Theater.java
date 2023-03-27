package com.example.kinozippy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int rows;
    private int numberedSeats;

    @OneToMany(mappedBy = "theater")
    @JsonBackReference
    private List<ShowTime> showTimes;

    // constructors
    public Theater(long id, String name, int rows, int numberedSeats, List<ShowTime> showTimes) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.numberedSeats = numberedSeats;
        this.showTimes = showTimes;
    }


    public Theater() {

    }


    // getters setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getNumberedSeats() {
        return numberedSeats;
    }

    public void setNumberedSeats(int numberedSeats) {
        this.numberedSeats = numberedSeats;
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }
}
