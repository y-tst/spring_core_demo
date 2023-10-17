package edu.yanchuk.spring.demo.interfaces.services;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.implementation.Ticket;
import edu.yanchuk.spring.demo.implementation.User;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(long userId, long eventId, int seat);
    void cancelTicket(long ticketId);
    List<Ticket> getBookedTickets(User user);
    List<Ticket> getBookedTickets(Event event);
}
