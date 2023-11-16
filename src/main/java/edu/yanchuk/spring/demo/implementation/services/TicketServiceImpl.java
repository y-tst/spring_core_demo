package edu.yanchuk.spring.demo.implementation.services;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.implementation.Ticket;
import edu.yanchuk.spring.demo.implementation.User;
import edu.yanchuk.spring.demo.interfaces.dao.TicketDAO;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private TicketDAO ticketDAO;

    public TicketServiceImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int seat) {
        return ticketDAO.bookTicket(userId, eventId, seat);
    }

    @Override
    public void cancelTicket(long ticketId) {
        ticketDAO.cancelTicket(ticketId);
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        return ticketDAO.getBookedTickets(user);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        return ticketDAO.getBookedTickets(event);
    }
}

