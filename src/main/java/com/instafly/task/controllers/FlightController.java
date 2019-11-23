package com.instafly.task.controllers;

import com.instafly.task.models.Flight;
import com.instafly.task.models.FlightService;
import com.instafly.task.models.Ticket;
import com.instafly.task.models.TicketService;
import net.bytebuddy.implementation.MethodAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    TicketService ticketService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable int id) {
        return flightService.getFlight(id);
    }

    @PostMapping
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @PutMapping
    public void updateFlight(@RequestBody Flight flight) {
        flightService.updateFlight(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }

    //leverageing ADMIN with capability to fetch all booked tickets
    @GetMapping("/tickets")
    public List<Ticket> getAllTicketes() {
        return ticketService.getAllTickets();
    }
}
