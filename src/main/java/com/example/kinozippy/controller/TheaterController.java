package com.example.kinozippy.controller;

import com.example.kinozippy.model.Theater;
import com.example.kinozippy.repository.TheaterRepository;
import com.example.kinozippy.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class TheaterController {
    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterController(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    // handles GET requests to /theaters and returns a list of all theater entities in the repository.
    @GetMapping("/theaters")
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // handles POST requests to /theater and adds a new theater entity to the repository.
    @PostMapping("/theater")
    public Theater addTheater(@RequestBody Theater theater) {
        return theaterRepository.save(theater);
    }

    // handles GET requests to /theater/{id} and returns the theater entity with the specified ID.
    @GetMapping("/theater/{id}")
    public Theater getTheaterById(@PathVariable(value = "id") long theaterId) {
        return theaterRepository.findById(theaterId)
                .orElseThrow(null);
    }
}
