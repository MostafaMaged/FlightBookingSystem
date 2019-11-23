package com.instafly.task.repositories;

import com.instafly.task.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByOrigin(String origin);
    List<Flight> findByDestination(String destination);
}
