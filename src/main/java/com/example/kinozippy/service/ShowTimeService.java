package com.example.kinozippy.service;

import com.example.kinozippy.model.Movie;
import com.example.kinozippy.model.ShowTime;
import com.example.kinozippy.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShowTimeService {

    @Autowired
    ShowTimeRepository showTimeRepository;

    public ResponseEntity<ShowTime> postShowTime(ShowTime showTime) {
        if (doesShowTimeExist(showTime)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        ShowTime postedShowTime = showTimeRepository.save(showTime);
        return new ResponseEntity<>(postedShowTime, HttpStatus.OK);
    }

    public List<ShowTime> getShowTime() {
        return showTimeRepository.findAll();
    }

    public Optional<ShowTime> getShowTIme(Long id) {
        return showTimeRepository.findById(id);
    }

    public ResponseEntity<ShowTime> putShowTime(ShowTime showTime, long showTimeId) {
        if (doesShowTimeExist(showTimeId)) {
            showTime.setId(showTimeId);
            ShowTime updatedShowTime = showTimeRepository.save(showTime);
            return new ResponseEntity<>(updatedShowTime, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ShowTime> deleteShowTime(long showTimeId) {
        Optional<ShowTime> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (doesShowTimeExist(showTimeId)) {
            ShowTime deletedShowTime = optionalShowTime.get();
            showTimeRepository.deleteById(showTimeId);
            return new ResponseEntity<>(deletedShowTime, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ShowTime saveShowTime(ShowTime showTime) {
        return showTimeRepository.save(showTime);
    }

    private boolean doesShowTimeExist(ShowTime showTime) {
        Long showTimeId = showTime.getId();
        return doesShowTimeExist(showTimeId);
    }

    private boolean doesShowTimeExist(Long id) {
        boolean isIdSet = id != null;
        return isIdSet && showTimeRepository.existsById(id);
    }
}
