package com.example.airport.model.dto;

import com.example.airport.model.Airport;
import com.example.airport.model.Status;
import lombok.Getter;

@Getter
public class AirportOutputDto {

    private final Long id;
    private final String name;
    private final Status status;
    private final String city;

    public AirportOutputDto(Airport command){
        this.id = command.getId();
        this.name = command.getName();
        this.status = command.getStatus();
        this.city = command.getCity();
    }
}
