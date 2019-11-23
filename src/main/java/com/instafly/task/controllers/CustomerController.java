package com.instafly.task.controllers;

import com.instafly.task.models.Flight;
import com.instafly.task.models.FlightService;
import com.instafly.task.models.Ticket;
import com.instafly.task.models.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    FlightService flightService;

    @Autowired
    TicketService ticketService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/searchByOrigin/{origin}")
    public List<Flight> getFlightsByOrigin(@PathVariable String origin) {
        return flightService.getFlightsByOrigin(origin);
    }

    @GetMapping("/searchByDest/{destination}")
    public List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return flightService.getFlightsByDestination(destination);
    }

    @PostMapping
    public void bookFlight(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    @PutMapping("/{id}")
    public void upgradeTicket(@PathVariable int id) {
        ticketService.upgradeTicket(id);
    }

    @DeleteMapping("/{id}")
    public void cancelTicket(@PathVariable int id) {
        ticketService.deleteTicket(id);
    }

}
