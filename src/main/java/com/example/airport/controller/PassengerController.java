package com.example.airport.controller;

import com.example.airport.model.dto.PassengerInputDto;
import com.example.airport.service.FlightService;
import com.example.airport.service.PassengerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/passenger")
public class PassengerController {

    private final PassengerService passengerService;
    private final FlightService flightService;

    public PassengerController(PassengerService passengerService, FlightService flightService) {
        this.passengerService = passengerService;
        this.flightService = flightService;
    }

    @GetMapping("/new/{flight_id}")
    public String createForm(@PathVariable("flight_id") Long flight_id, Model model){
        model.addAttribute("passenger", new PassengerInputDto());
        model.addAttribute("flight", flightService.getById(flight_id));

        return "addPassenger";
    }

    @PostMapping
    public String create(@ModelAttribute("passenger") PassengerInputDto command){
        passengerService.create(command);

        return "redirect:/flights";
    }
}
