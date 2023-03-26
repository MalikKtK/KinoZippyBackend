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

    @Query("SELECT event_name, COUNT(*) AS tickets_sold FROM tickets JOIN events ON tickets.event_id = events.event_id GROUP BY event_name")
    List<Map<String, Object>> ticketsSoldPerEvent();

    //GroupBy showtimeID
}
