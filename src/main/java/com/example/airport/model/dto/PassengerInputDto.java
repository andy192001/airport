package com.example.airport.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerInputDto {

    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private Long flightId;
}
