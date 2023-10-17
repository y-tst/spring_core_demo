package edu.yanchuk.spring.demo.interfaces.services;

import edu.yanchuk.spring.demo.implementation.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);
    Event getEventById(long eventId);
    List<Event> getAllEvents();
    void updateEvent(Event event);
    void deleteEvent(long eventId);
}
