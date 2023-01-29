package com.example.airport.service;

import com.example.airport.model.Airport;
import com.example.airport.model.Status;
import com.example.airport.model.dto.AirportInputDto;
import com.example.airport.model.dto.AirportOutputDto;
import com.example.airport.repository.AirportRepository;
import com.example.airport.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    private final StatusRepository statusRepository;

    public AirportService(AirportRepository airportRepository, StatusRepository status) {
        this.airportRepository = airportRepository;
        this.statusRepository = status;
    }

    public void create(AirportInputDto command){
        Status status = statusRepository.findById(command.getStatusId()).get();
        Airport airport = new Airport(command, status);
        airportRepository.save(airport);
    }

    public List<AirportOutputDto> getAll(){
        return airportRepository.findAll()
                .stream()
                .map(AirportOutputDto::new)
                .collect(Collectors.toList());
    }
}
