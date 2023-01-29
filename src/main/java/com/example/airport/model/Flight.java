package com.example.airport.model;

import com.example.airport.model.dto.FlightInputDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long number;

    Long capacity;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "departured_location")
    private Airport departuredLocation;

    @ManyToOne
    @JoinColumn(name = "arrival_location")
    private Airport arrivalLocation;


    @Column(name = "date_from")
    private Date dateFrom;


    @Column(name = "time_from")
    private Time timeFrom;

    @Column(name = "time_to")
    private Time timeTo;

    public Flight(FlightInputDto command, Airline airline, Airport departuredLocation, Airport arrivalLocation) {
        this.number = command.getNumber();
        this.capacity = command.getCapacity();
        this.airline = airline;
        this.departuredLocation = departuredLocation;
        this.arrivalLocation = arrivalLocation;
    }
}
