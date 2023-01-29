package com.example.airport.controller;

import com.example.airport.model.dto.FlightOutputDto;
import com.example.airport.service.FlightService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/flights_api")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping()
    public List<FlightOutputDto> getAll(){
        return flightService.getAll();
    }

    @GetMapping("/search")
    public List<FlightOutputDto> search(@RequestParam(value = "departure", required = false) Long departureId,
                                        @RequestParam(value = "arrival", required = false) Long arrivalId,
                                        @RequestParam(value = "dateFrom", required = false) Date dateFrom){
        return flightService.search(departureId, arrivalId, dateFrom);
    }

    @PutMapping()
    public void updateFlight(){

    }

    @PostMapping()
    public void create(){

    }

    @DeleteMapping()
    public void delete(@PathVariable Long id){

    }
}
