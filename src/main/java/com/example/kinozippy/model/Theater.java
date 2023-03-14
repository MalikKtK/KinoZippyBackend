package com.example.kinozippy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Theater {

    @Id
    private long id;
    private String name;
    private int seatRow;
    private int seatNumber;

    // constructors
    public Theater(long id, String name, int seatRow, int seatNumber) {
        this.id = id;
        this.name = name;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public Theater() {

    }

    // getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
