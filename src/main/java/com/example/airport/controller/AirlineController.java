package com.example.airport.controller;


import com.example.airport.model.dto.AirlineInputDto;
import com.example.airport.model.dto.AirlineOutputDto;
import com.example.airport.service.AirlineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public void create(@RequestBody AirlineInputDto command){
        airlineService.create(command);
    }

    @GetMapping
    public List<AirlineOutputDto> getAll(){
        return airlineService.getAll();
    }
}
