package com.example.airport.model;

import com.example.airport.model.dto.PassengerInputDto;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Long age;

    private String email;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Passenger(PassengerInputDto command, Flight flight){
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.age = command.getAge();
        this.email = command.getEmail();
        this.flight = flight;
    }

}
