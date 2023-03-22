package com.example.kinozippy.repository;

import com.example.kinozippy.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // get all tickets by showtime id
    @Query("SELECT t FROM Ticket t WHERE t.showTime.id = :showTimeId")
    List<Ticket> findAllByShowTimeId(long showTimeId);



}
