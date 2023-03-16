package com.example.kinozippy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Many tickets can be assigned to one showtime
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", nullable = false)
    @JsonBackReference
    private ShowTime showTime;
    private int seatRow;
    private int seatNumber;
    private double price;
    private boolean isPaid;

    // ### constructors ###
    public Ticket(long id, ShowTime ShowTime, int seatRow, int seatNumber, double price, boolean isPaid) {
        this.id = id;
        this.showTime = ShowTime;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isPaid = isPaid;
    }

    public Ticket() {
    }

    // ### getters setters ###
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
