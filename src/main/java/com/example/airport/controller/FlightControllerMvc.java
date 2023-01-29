package com.example.airport.controller;

import com.example.airport.model.dto.FlightOutputDto;
import com.example.airport.service.AirportService;
import com.example.airport.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/flights")
public class FlightControllerMvc {

    private final FlightService flightService;
    private final AirportService airportService;

    public FlightControllerMvc(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping()
    public String searchPage(Model model){
        model.addAttribute("airports", airportService.getAll());

        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "departure", required = false) Long departureId,
                         @RequestParam(value = "arrival", required = false) Long arrivalId,
                         @RequestParam(value = "dateFrom", required = false) Date dateFrom,
                         Model model){
        List<FlightOutputDto> searchOutput = flightService.search(departureId, arrivalId, dateFrom);
        model.addAttribute("flightList", searchOutput);
        model.addAttribute("airports", airportService.getAll());
        
        return "flightsPage";
    }
}
