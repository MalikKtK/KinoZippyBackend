package com.example.kinozippy.repository;

import com.example.kinozippy.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // get all tickets by showtime id
    @Query("SELECT t FROM Ticket t WHERE t.showTime.id = :showTimeId")
    public Ticket findByShowTimeId(Long showTimeId);
}
