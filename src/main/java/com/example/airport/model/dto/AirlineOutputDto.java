package com.example.airport.model.dto;

import com.example.airport.model.Airline;
import lombok.Getter;

@Getter
public class AirlineOutputDto {
    private final Long id;
    private final String name;

    public AirlineOutputDto(Airline airline){
        this.id = airline.getId();
        this.name = airline.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
