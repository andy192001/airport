package com.example.airport.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class FlightInputDto {

    private Long number;
    private Long capacity;
    private Long airlineId;
    private Long departuredLocationId;
    private Long arrivalLocationId;
    private Date dateFrom;
    private Time timeFrom;
    private Time timeTo;
}
