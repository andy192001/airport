package com.example.airport.model.dto;

import com.example.airport.model.Flight;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class FlightOutputDto {
    private final Long id;
    private final Long number;
    private final Long capacity;
    private final AirlineOutputDto airline;
    private final AirportOutputDto departuredLocation;
    private final AirportOutputDto arrivalLocation;
    private final Date dateFrom;
    private final Time timeFrom;
    private final Time timeTo;

    public FlightOutputDto(Flight command) {
        this.id = command.getId();
        this.number = command.getNumber();
        this.capacity = command.getCapacity();
        this.airline = new AirlineOutputDto(command.getAirline());
        this.departuredLocation = new AirportOutputDto(command.getDeparturedLocation());
        this.arrivalLocation = new AirportOutputDto(command.getArrivalLocation());
        this.dateFrom = command.getDateFrom();
        this.timeFrom = command.getTimeFrom();
        this.timeTo = command.getTimeTo();
    }
}
