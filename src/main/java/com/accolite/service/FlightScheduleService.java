package com.accolite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.dao.FlightScheduleMethod;
import com.accolite.pojo.FlightSchedule;

@Service
public class FlightScheduleService implements FlightScheduleMethod {

    List<FlightSchedule> list = new ArrayList<>();

    @Override
    public void addSchedule(FlightSchedule schedule) {
	try {
	    list.add(schedule);

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    @Override
    public List<FlightSchedule> getSchedule() {

	return list;
    }

}
