package com.example.kinozippy.controller;

import com.example.kinozippy.exception.ResourceNotFoundException;
import com.example.kinozippy.model.ShowTime;
import com.example.kinozippy.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ShowTimeController {
    @Autowired
    ShowTimeService showTimeService;

    @PostMapping("/showtime")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ShowTime> postShowTime(@RequestBody ShowTime showTime) {
        return showTimeService.postShowTime(showTime);
    }

    @GetMapping("/showtimes")
    public List<ShowTime> getShowTimes() {
        return showTimeService.getShowTime();
    }

    @GetMapping("/showtime/{id}")
    public ShowTime getShowTime(@PathVariable long id) {
        return showTimeService.getShowTIme(id).orElseThrow( ()-> new ResourceNotFoundException("ShowTime with id: " + id));
    }

    @PutMapping("/showtime/{id}")
    public ResponseEntity<ShowTime> putShowTime(@PathVariable long id, @RequestBody ShowTime showTime) {
        return  showTimeService.putShowTime(showTime, id);
    }
    @DeleteMapping("/showtime/{id}")
    public ResponseEntity<ShowTime> deleteShowTime(@PathVariable long id) {
        return showTimeService.deleteShowTime(id);
    }



}
