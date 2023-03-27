package com.example.kinozippy.controller;

import com.example.kinozippy.exception.ResourceNotFoundException;
import com.example.kinozippy.model.Movie;
import com.example.kinozippy.model.ShowTime;
import com.example.kinozippy.model.Ticket;
import com.example.kinozippy.repository.TicketRepository;
import com.example.kinozippy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class TicketController {
    private final TicketRepository ticketRepository;

    private final MovieService movieService;

    @Autowired
    public TicketController(TicketRepository ticketRepository, MovieService movieService) {
        this.ticketRepository = ticketRepository;
        this.movieService = movieService;
    }

    // handles GET requests to /Tickets and returns a list of all Ticket entities in the repository.
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/tickets/movie/{id}")
    public List<Ticket> getAllTicketsFromMovie(@PathVariable long id) {
        Optional<Movie> optionalMovie = movieService.getMovie(id);
        if (optionalMovie.isPresent()) {
            List<Ticket> allTicketSalesFromMovie = new ArrayList<>();
            List<ShowTime> movieShowTimes = optionalMovie.get().getShowTimes();
            movieShowTimes.forEach(showTime -> {
                List<Ticket> showTimeTickets = showTime.getTickets();
                allTicketSalesFromMovie.addAll(showTimeTickets);
            });
            return allTicketSalesFromMovie;
        } else {
            throw new ResourceNotFoundException("All the tickets for a Movie with id: " + id);
        }
    }

    // handles POST requests to /Ticket and adds a new Ticket entity to the repository.
    @PostMapping("/ticket")
    public Ticket addTicket(@RequestBody Ticket Ticket) {
        return ticketRepository.save(Ticket);
    }

    // handles GET requests to /Ticket/{id} and returns the Ticket entity with the specified ID.
    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable(value = "id") long TicketId) {
        return ticketRepository.findById(TicketId)
                .orElseThrow(null);
    }

    @GetMapping("/tickets/showtime/{id}")
    public List<Ticket> getTicketsByShowTimeId(@PathVariable(value = "id") long showTimeId) {
        return ticketRepository.findAllByShowTimeId(showTimeId);
    }

    // handles DELETE requests to /Ticket/{id} and deletes the Ticket entity with the specified ID.
    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable(value = "id") long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElse(null);

        ticketRepository.delete(ticket);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Ticket existingTicket = optionalTicket.get();
        existingTicket.setShowTime(ticket.getShowTime());
        existingTicket.setCustomer(ticket.getCustomer());
        existingTicket.setSeatRow(ticket.getSeatRow());
        existingTicket.setSeatNumber(ticket.getSeatNumber());
        existingTicket.setPrice(ticket.getPrice());
        existingTicket.setPaid(ticket.isPaid());
        existingTicket.setAttended(ticket.isAttended());

        ticketRepository.save(existingTicket);
        return ResponseEntity.ok(existingTicket);
    }

    @GetMapping("/tickets/sales")
    public List<Map<String, Object>> getTicketSales() {
        return ticketRepository.ticketSales();
    }

}
