package com.example.airport.service;

import com.example.airport.model.Flight;
import com.example.airport.model.Passenger;
import com.example.airport.model.dto.PassengerInputDto;
import com.example.airport.model.dto.PassengerOutputDto;
import com.example.airport.repository.FlightRepository;
import com.example.airport.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    public PassengerService(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    public void create(PassengerInputDto command){
        Flight flight = flightRepository.findById(command.getFlightId()).get();
        Passenger passenger = new Passenger(command, flight);

        passengerRepository.save(passenger);
    }

    public List<PassengerOutputDto> getAll(){
        return passengerRepository.findAll()
                .stream()
                .map(PassengerOutputDto::new)
                .collect(Collectors.toList());
    }
}
