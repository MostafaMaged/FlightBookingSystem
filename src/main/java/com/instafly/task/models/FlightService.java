package com.instafly.task.models;

import com.instafly.task.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll()
                .forEach(flights::add);
        return flights;
    }

    public List<Flight> getFlightsByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }

    public List<Flight> getFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }

    public Flight getFlight(int id) {
        Optional<Flight> flight = flightRepository.findById(id);
        flight.orElseThrow(() -> new UsernameNotFoundException("Not Found " + id));
        return flight.get();
    }

    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

}
