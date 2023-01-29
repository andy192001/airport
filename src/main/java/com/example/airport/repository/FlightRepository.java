package com.example.airport.repository;

import com.example.airport.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByDeparturedLocationIdAndArrivalLocationIdAndDateFrom(Long departuredLocation_id, Long arrivalLocation_id, Date dateFrom);
}
