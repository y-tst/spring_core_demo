package edu.yanchuk.spring.demo.implementation.services;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.interfaces.dao.EventDAO;
import edu.yanchuk.spring.demo.interfaces.services.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private EventDAO eventDAO; // Inject the EventDAO

    // Constructor-based injection
    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    @Override
    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventDAO.deleteEvent(eventId);
    }
}
