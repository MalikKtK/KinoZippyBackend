package com.example.kinozippy.model;

import com.example.kinozippy.model.user.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Many tickets can be assigned to one showtime
    @ManyToOne()
    @JoinColumn(name = "showtime_id", referencedColumnName = "id", nullable = false)
    private ShowTime showTime;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    private int seatRow;
    private int seatNumber;
    private double price;
    private boolean isPaid;
    private boolean attended;

    // ### constructors ###
    public Ticket(long id, ShowTime ShowTime, Customer customer, int seatRow, int seatNumber, double price, boolean isPaid, boolean attended) {
        this.id = id;
        this.showTime = ShowTime;
        this.customer = customer;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isPaid = isPaid;
        this.attended = attended;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean hasAttended) {
        this.attended = hasAttended;
    }
}
