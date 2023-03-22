package com.example.kinozippy.controller;

import com.example.kinozippy.config.SortShowTimesByDate;
import com.example.kinozippy.exception.ResourceNotFoundException;
import com.example.kinozippy.model.Movie;
import com.example.kinozippy.model.ShowTime;
import com.example.kinozippy.model.enums.AgeLimit;
import com.example.kinozippy.model.enums.Category;
import com.example.kinozippy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class MovieController {
    @Autowired
    MovieService movieService;


    @GetMapping("/movie/agelimits")
    public List<AgeLimit> getAgeLimits() {
        return AgeLimit.getAllAgeLimits();
    }

    @GetMapping("/movie/categories")
    public List<Category> getCategories() {
        return Category.getAllCategories();
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        return movieService.postMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable long id) {
        return movieService.getMovie(id).orElseThrow( ()-> new ResourceNotFoundException("Movie with id: " + id));
    }

    @GetMapping("/movie/{id}/showtimes")
    public List<ShowTime> getMovieShowtimes(@PathVariable long id) {
        Optional<Movie> optionalMovie = movieService.getMovie(id);
        if (optionalMovie.isPresent()) {
            List<ShowTime> movieShowTimes = optionalMovie.get().getShowTimes();
            movieShowTimes.sort(new SortShowTimesByDate());
            return movieShowTimes;
        }
        throw new ResourceNotFoundException("ShowTimes with a Movie with id: " + id);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> putMovie(@PathVariable long id, @RequestBody Movie movie) {
        return  movieService.putMovie(movie, id);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping("/movie_schedule")
    public List<Map<String, Object>> movieSchedule() {
        return movieService.movieSchedule();
    }


}
