package com.example.airport.service;

import com.example.airport.model.Airline;
import com.example.airport.model.dto.AirlineInputDto;
import com.example.airport.model.dto.AirlineOutputDto;
import com.example.airport.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public void create(AirlineInputDto command){
        Airline airline = new Airline(command);
        airlineRepository.save(airline);
    }

    public List<AirlineOutputDto> getAll(){
        return airlineRepository.findAll()
                .stream()
                .map(AirlineOutputDto::new)
                .collect(Collectors.toList());
    }
}
