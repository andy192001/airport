package com.example.airport.service;

import com.example.airport.model.Airline;
import com.example.airport.model.Airport;
import com.example.airport.model.Flight;
import com.example.airport.model.dto.FlightInputDto;
import com.example.airport.model.dto.FlightOutputDto;
import com.example.airport.repository.AirlineRepository;
import com.example.airport.repository.AirportRepository;
import com.example.airport.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final AirlineRepository airlineRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository, AirlineRepository airlineRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.airlineRepository = airlineRepository;
    }

    public void create(FlightInputDto command){
        Airline airline = airlineRepository.findById(command.getAirlineId()).get();
        Airport departuredLocation = airportRepository.findById(command.getDeparturedLocationId()).get();
        Airport arrivalLocation = airportRepository.findById(command.getArrivalLocationId()).get();

        Flight flight = new Flight(command, airline, departuredLocation, arrivalLocation);
        flightRepository.save(flight);
    }

    public FlightOutputDto getById(Long id){
        Flight flight = flightRepository.findById(id).get();
        return new FlightOutputDto(flight);
    }

    public List<FlightOutputDto> search(Long departuredLocationId, Long arrivalLocationId, Date dateFrom){
        return flightRepository.findAllByDeparturedLocationIdAndArrivalLocationIdAndDateFrom(departuredLocationId, arrivalLocationId, dateFrom)
                .stream()
                .map(FlightOutputDto::new)
                .collect(Collectors.toList());
    }

    public List<FlightOutputDto> getAll(){
        return flightRepository.findAll().stream()
                .map(FlightOutputDto::new)
                .collect(Collectors.toList());
    }
}
