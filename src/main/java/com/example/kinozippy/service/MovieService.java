package com.example.kinozippy.service;

import com.example.kinozippy.model.Movie;
import com.example.kinozippy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public ResponseEntity<Movie> postMovie(Movie movie) {
    if (doesMovieExist(movie)) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    Movie postedMovie = movieRepository.save(movie);
    return new ResponseEntity<>(postedMovie, HttpStatus.OK);
  }

  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> getMovie(Long id) {
    return movieRepository.findById(id);
  }

  public ResponseEntity<Movie> putMovie(Movie movie, long movieId) {
    if (doesMovieExist(movieId)) {
      movie.setId(movieId);
      Movie updatedMovie = movieRepository.save(movie);
      return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<Movie> deleteMovie(long movieId) {
    Optional<Movie> optionalMovie = movieRepository.findById(movieId);
    if (doesMovieExist(movieId)) {
      Movie deletedMovie = optionalMovie.get();
      movieRepository.deleteById(movieId);
      return new ResponseEntity<>(deletedMovie, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  private boolean doesMovieExist(Movie movie) {
    Long movieId = movie.getId();
    return doesMovieExist(movieId);
  }

  private boolean doesMovieExist(Long id) {
    boolean isIdSet = id != null;
    return isIdSet && movieRepository.existsById(id);
  }
}
