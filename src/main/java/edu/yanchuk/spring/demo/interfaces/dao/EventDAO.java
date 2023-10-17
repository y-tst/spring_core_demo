package edu.yanchuk.spring.demo.interfaces.dao;

import edu.yanchuk.spring.demo.implementation.Event;

import java.util.List;

public interface EventDAO {

    Event createEvent(Event event);
    Event getEventById(long eventId);
    List<Event> getAllEvents();
    void updateEvent(Event event);
    void deleteEvent(long eventId);
}
