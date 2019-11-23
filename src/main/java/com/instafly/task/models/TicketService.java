package com.instafly.task.models;

import com.instafly.task.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll()
                .forEach(tickets::add);
        return tickets;
    }

    public void upgradeTicket(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if(ticket.get().getClassType() == ClassType.ECONOMY) {
            ticket.get().setClassType(ClassType.BUSINESS);
        }
        else if (ticket.get().getClassType() == ClassType.FIRSTCLASS) {
            ticket.get().setClassType(ClassType.FIRSTCLASS);
        }
        ticketRepository.save(ticket.get());
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }
}
