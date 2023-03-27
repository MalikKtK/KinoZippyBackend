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

    // ticket statistics
    @Query(value = """
            SELECT sold.showtime_id,
                   sold.tickets_sold,
                   attended.tickets_attended
            FROM (SELECT show_time.id                  AS showtime_id,
                         COALESCE(COUNT(ticket.id), 0) AS tickets_sold
                  FROM show_time
                           LEFT JOIN ticket ON show_time.id = ticket.showtime_id
                  GROUP BY show_time.id) AS sold
                     LEFT JOIN (SELECT show_time.id                                                            AS showtime_id,
                                       COALESCE(COUNT(CASE WHEN ticket.attended = true THEN ticket.id END), 0) AS tickets_attended
                                FROM show_time
                                         LEFT JOIN ticket ON show_time.id = ticket.showtime_id
                                GROUP BY show_time.id) AS attended ON sold.showtime_id = attended.showtime_id""", nativeQuery = true)
    List<Map<String, Object>> ticketSales();
}
