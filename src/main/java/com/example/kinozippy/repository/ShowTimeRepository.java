package com.example.kinozippy.repository;

import com.example.kinozippy.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {

}
