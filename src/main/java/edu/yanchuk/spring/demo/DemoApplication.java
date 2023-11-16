package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.implementation.Storage;
import edu.yanchuk.spring.demo.implementation.User;
import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DemoApplication {


    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
        public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        EventService eventService = context.getBean("eventService", EventService.class);
        TicketService ticketService = context.getBean("ticketService", TicketService.class);

        userService.getAllUsers().forEach(System.out::println);
        eventService.getAllEvents().forEach(System.out::println);

        Long userToUpdateId = 1l;

        User userToUpdate = new User(userToUpdateId, "Updated User Name", "updated_email@test.com");
        userService.updateUser(userToUpdate);
        logger.info("User with ID %s is updated.", userToUpdateId);
        userService.getAllUsers().forEach(System.out::println);


//        SpringApplication.run(DemoApplication.class, args);
         context.close();
    }
}