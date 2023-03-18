package com.example.kinozippy.config;

import com.example.kinozippy.model.ShowTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

public class SortShowTimesByDate implements Comparator<ShowTime> {
  @Override
  public int compare(ShowTime showTime1, ShowTime showTime2) {
    LocalDate startDateShow1 = showTime1.getStartTime().toLocalDate();
    LocalDate startDateShow2 = showTime2.getStartTime().toLocalDate();
    if (startDateShow1.compareTo(startDateShow2) != 0) {
      return startDateShow1.compareTo(startDateShow2);
    } else {
      LocalTime startTimeShow1 = showTime1.getStartTime().toLocalTime();
      LocalTime startTimeShow2 = showTime2.getStartTime().toLocalTime();
      return startTimeShow1.compareTo(startTimeShow2);
    }
  }
}
