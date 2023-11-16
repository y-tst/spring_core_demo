package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.implementation.Event;
import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventManipulationTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void createNewEvent () {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EventService eventService = context.getBean("eventService", EventService.class);

        logger.info("Let's check existed events: ");
        eventService.getAllEvents().forEach(System.out::println);

        logger.info("Let's create new event: ");
        eventService.createEvent(new Event(333l, "Best Standup Ever", "Grand Opera, 1, Praga blvrd"));
        eventService.getAllEvents().forEach(System.out::println);

        logger.info("Let's update the event having ID #1: ");

        String previousName = eventService.getEventById(1l).getName();
        String previousLocation = eventService.getEventById(1l).getLocation();

        eventService.updateEvent(new Event(1l, "Updated Event Name", "Updated Event Location"));

        String updatedName = eventService.getEventById(1l).getName();
        String updatedLocation = eventService.getEventById(1l).getLocation();

        assertEquals("Updated Event Name", updatedName);
        assertEquals("Updated Event Location", updatedLocation);

        eventService.getAllEvents().forEach(System.out::println);

    }
}
