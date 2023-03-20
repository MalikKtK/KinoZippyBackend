package com.example.kinozippy.controller;

import com.example.kinozippy.model.ShowTime;
import com.example.kinozippy.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ShowTimeController {
    private final ShowTimeRepository showTimeRepository;

    @Autowired
    public ShowTimeController(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    // handles GET requests to /ShowTimes and returns a list of all ShowTime entities in the repository.
    @GetMapping("/showtimes")
    public List<ShowTime> getAllShowTimes() {
        return showTimeRepository.findAll();
    }

    // handles POST requests to /ShowTime and adds a new ShowTime entity to the repository.
    @PostMapping("/showtime")
    public ShowTime addShowTime(@RequestBody ShowTime ShowTime) {
        return showTimeRepository.save(ShowTime);
    }

    // handles GET requests to /ShowTime/{id} and returns the ShowTime entity with the specified ID.
    @GetMapping("/showtime/{id}")
    public ShowTime getShowTimeById(@PathVariable(value = "id") long ShowTimeId) {
        return showTimeRepository.findById(ShowTimeId)
                .orElseThrow(null);
    }


    // handles PUT requests to /ShowTime/{id} and updates the ShowTime entity with the specified ID.
    @PutMapping("/showtime/{id}")
    public ShowTime updateShowTime(@PathVariable(value = "id") long ShowTimeId,
                                   @RequestBody ShowTime ShowTimeDetails) {

        ShowTime ShowTime = showTimeRepository.findById(ShowTimeId)
                .orElse(null);

        ShowTime.setStartTime(ShowTimeDetails.getStartTime());
        ShowTime.setEndTime(ShowTimeDetails.getEndTime());
        ShowTime.setTickets(ShowTimeDetails.getTickets());

        ShowTime updatedShowTime = showTimeRepository.save(ShowTime);
        return updatedShowTime;
    }

    // handles DELETE requests to /ShowTime/{id} and deletes the ShowTime entity with the specified ID.
    @DeleteMapping("/showtime/{id}")
    public ResponseEntity<?> deleteShowTime(@PathVariable(value = "id") long ShowTimeId) {
        ShowTime ShowTime = showTimeRepository.findById(ShowTimeId)
                .orElse(null);

        showTimeRepository.delete(ShowTime);

        return ResponseEntity.ok().build();
    }

    // todo add method to get all showRimes for a timeRange



}
