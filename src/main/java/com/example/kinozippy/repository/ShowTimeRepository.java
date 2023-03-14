package com.example.kinozippy.repository;

import com.example.kinozippy.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {

//    @Query("SELECT s FROM ShowTime s WHERE s.Movie.id = :movieId")
//    public List<ShowTime> findByMovieId(@Param("movieId") Long movieId);

}
