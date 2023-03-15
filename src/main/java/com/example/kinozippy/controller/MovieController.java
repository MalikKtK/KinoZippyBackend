package com.example.kinozippy.controller;

import com.example.kinozippy.model.Movie;
import com.example.kinozippy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // handles GET requests to /movies and returns a list of all movie entities in the repository.
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // handles POST requests to /movie and adds a new movie entity to the repository.
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // handles GET requests to /movie/{id} and returns the movie entity with the specified ID.
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable(value = "id") long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(null);
    }






}
