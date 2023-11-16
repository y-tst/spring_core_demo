package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketManipulationTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void ticketCreationTest() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TicketService ticketService = context.getBean("ticketService", TicketService.class);
        UserService userService = context.getBean("userService", UserService.class);
        EventService eventService = context.getBean("eventService", EventService.class);

        logger.info("Let's check booked tickets by User having ID 1: ");
        ticketService.getBookedTickets(userService.getUserById(1l)).forEach(System.out::println);

        logger.info("Let's check booked tickets by Event having ID 2: ");
        ticketService.getBookedTickets(eventService.getEventById(2l)).forEach(System.out::println);

        logger.info("Let's add booked ticket for User having ID 1 on Event with ID 2 on seat 55: ");
        ticketService.bookTicket(1l, 2l, 55);

        assertEquals(ticketService.getBookedTickets(userService.getUserById(1l)).size(), 2);
        ticketService.getBookedTickets(userService.getUserById(1l)).forEach(System.out::println);
    }
}
