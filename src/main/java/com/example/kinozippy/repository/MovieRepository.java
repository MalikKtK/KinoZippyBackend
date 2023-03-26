package com.example.kinozippy.repository;

import com.example.kinozippy.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // get all tickets by showtime id as well as movie info
    @Query(value = """
            SELECT show_time.id AS showtime_id,
                   COALESCE(COUNT(ticket.id), 0) AS showtime_tickets,
                   show_time.price AS showtime_price,
                   show_time.start_time AS showtime_start_time,
                   show_time.end_time AS showtime_end_time,
                   m.movie_id AS movie_id,
                   m.title AS movie_title,
                   m.age_limit AS movie_age_limit,
                   m.category AS movie_category,
                   m.length_in_minutes AS movie_length_in_minutes,
                   m.rating AS movie_rating,
                   t.id AS theater_id,
                   t.rows * t.numbered_seats AS theater_seats,
                   t.name AS theater_name
            FROM show_time
                     LEFT JOIN ticket ON show_time.id = ticket.showtime_id
                     LEFT JOIN movies m ON m.movie_id = show_time.movie_id
                     LEFT JOIN theater t ON t.id = show_time.theater_id
            GROUP BY show_time.id""", nativeQuery = true)
    List<Map<String, Object>> movieSchedule();

    // Generate a report on tickets sold for each showtime
    @Query(value = """
            SELECT show_time.id AS showtime_id,
                   COALESCE(COUNT(ticket.id), 0) AS tickets_sold
            FROM show_time
                     LEFT JOIN ticket ON show_time.id = ticket.showtime_id
            GROUP BY show_time.id""", nativeQuery = true)
    List<Map<String, Object>> ticketsSoldReport();

}




