package com.example.kinozippy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

// specify a time for a given movie and theater
@Entity
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Many showTimes relate to one theater
    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToMany(mappedBy = "showTime", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    private double price;


    // extra
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    // ### constructors ###
    public ShowTime(long id, double price, Theater theater, Movie movie,
                    LocalDateTime startTime, LocalDateTime endTime,
                    List<Ticket> tickets) {
        this.id = id;
        this.price = price;
        this.theater = theater;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tickets = tickets;
    }

    public ShowTime() {
    }

    // ### getters setters ###
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
