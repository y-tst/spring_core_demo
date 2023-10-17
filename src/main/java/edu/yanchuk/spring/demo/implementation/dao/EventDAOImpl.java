package edu.yanchuk.spring.demo.implementation.dao;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.interfaces.dao.EventDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDAOImpl implements EventDAO {

    private final Map<Long, Event> eventMap = new HashMap<>();
    private long currentId = 1;


    @Override
    public Event createEvent(Event event) {
        event.setId(currentId);
        eventMap.put(currentId, event);
        currentId++;
        return event;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventMap.get(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void updateEvent(Event event) {
        if (eventMap.containsKey(event.getId())) {
            eventMap.put(event.getId(), event);
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }

    @Override
    public void deleteEvent(long eventId) {
        eventMap.remove(eventId);
    }
}
