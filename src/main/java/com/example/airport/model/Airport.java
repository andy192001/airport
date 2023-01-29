package com.example.airport.model;

import com.example.airport.model.dto.AirportInputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "airport")
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    public Airport(AirportInputDto command, Status status){
        this.name = command.getName();
        this.status = status;
        this.city = getCity();
    }
}
