package com.example.kinozippy.model;

import java.util.Date;
import java.util.List;

// specify a timeslot for a given movie and theater
public class timeSlot {

    private long id;
    private long theaterId;
    private long movieId;
    private Date startTime;
    private Date endTime;
    private List<SeatReservation> seatReservations;

}
