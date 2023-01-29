package com.example.airport.model.dto;

import com.example.airport.model.Passenger;
import lombok.Getter;

@Getter
public class PassengerOutputDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Long age;
    private final String email;
    private final FlightOutputDto flight;

    public PassengerOutputDto(Passenger command){
        this.id = command.getId();
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.age = command.getAge();
        this.email = command.getEmail();
        this.flight = new FlightOutputDto(command.getFlight());
    }
}
