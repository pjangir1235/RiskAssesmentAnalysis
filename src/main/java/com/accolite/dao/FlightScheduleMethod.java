package com.accolite.dao;

import java.util.List;

import com.accolite.pojo.FlightSchedule;

public interface FlightScheduleMethod {
    void addSchedule(FlightSchedule schedule);

    List<FlightSchedule> getSchedule();

}
