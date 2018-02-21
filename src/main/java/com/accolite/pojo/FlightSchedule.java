package com.accolite.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.MoreObjects;

public class FlightSchedule {
    private final int flightScheduleId;
    private final int aircraftId;
    private final int firstPilotId;
    private final int secondPilotId;
    private final String sourceDate;
    private final String destinationDate;
    private final int sourceLocationId;
    private final int destinationLocationId;

    @Override
    public String toString() {
	return MoreObjects.toStringHelper(this).add("flightScheduleId", flightScheduleId).add("aircraftId", aircraftId)
		.add("firstPilotId", firstPilotId).add("secondPilotId", secondPilotId).add("sourceDate", sourceDate)
		.add("destinationDate", destinationDate).add("sourceLocationId", sourceLocationId)
		.add("destinationLocationId", destinationLocationId).toString();
    }

    @JsonCreator
    public FlightSchedule(@JsonProperty("flightScheduleId") int flightScheduleId,
	    @JsonProperty("aircraftId") int aircraftId, @JsonProperty("firstPilotId") int firstPilotId,
	    @JsonProperty("secondPilotId") int secondPilotId, @JsonProperty("sourceDate") String sourceDate,
	    @JsonProperty("destinationDate") String destinationDate,
	    @JsonProperty("sourceLocationId") int sourceLocationId,
	    @JsonProperty("destinationLocationId") int destinationLocationId) {
	super();
	this.flightScheduleId = flightScheduleId;
	this.aircraftId = aircraftId;
	this.firstPilotId = firstPilotId;
	this.secondPilotId = secondPilotId;
	this.sourceDate = sourceDate;
	this.destinationDate = destinationDate;
	this.sourceLocationId = sourceLocationId;
	this.destinationLocationId = destinationLocationId;
    }

    public int getFlightScheduleId() {
	return flightScheduleId;
    }

    public int getAircraftId() {
	return aircraftId;
    }

    public int getFirstPilotId() {
	return firstPilotId;
    }

    public int getSecondPilotId() {
	return secondPilotId;
    }

    public String getSourceDate() {
	return sourceDate;
    }

    public String getDestinationDate() {
	return destinationDate;
    }

    public int getSourceLocationId() {
	return sourceLocationId;
    }

    public int getDestinationLocationId() {
	return destinationLocationId;
    }

}
