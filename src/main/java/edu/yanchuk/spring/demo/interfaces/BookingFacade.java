package edu.yanchuk.spring.demo.interfaces;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.implementation.Ticket;
import edu.yanchuk.spring.demo.implementation.User;

import java.util.List;

public interface BookingFacade {

    User addNewUser(User user);
    User getExistingUserById(long userId);
    List<User> getAllExistingUsers();
    void updateExistingUser(User user);
    void deleteExistingUser(long userId);

    Event createNewEvent(Event event);
    Event getExistingEventById(long eventId);
    List<Event> getAllExistingEvents();
    void updateExistingEvent(Event event);
    void deleteExistingEvent(long eventId);

    Ticket bookTicket(long userId, long eventId, int seat);
    void cancelTicket(long ticketId);
    List<Ticket> getBookedTickets(User user);
    List<Ticket> getBookedTickets(Event event);
}
