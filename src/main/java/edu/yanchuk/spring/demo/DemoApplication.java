package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.implementation.Storage;
import edu.yanchuk.spring.demo.implementation.User;
import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;


@SpringBootApplication
//@ComponentScan("edu.yanchuk.spring.demo.implementation")
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
        public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        EventService eventService = context.getBean("eventService", EventService.class);
        TicketService ticketService = context.getBean("ticketService", TicketService.class);
        Storage storage = context.getBean("storage", Storage.class);

        storage.getDataMap().forEach((key, value) -> {
            logger.info("Key: " + key + ", Value: " + value);
        });

        String userId = "User 1";
        AtomicReference<User> userToUpdate = new AtomicReference<>(new User());
        storage.getDataMap().forEach((key, value) -> {
                    if (key.equals(userId)) {
                        userToUpdate.set((User) storage.getDataMap().get(key));
                    }
                }
        );

        if (userToUpdate.get() != null) {
            userToUpdate.get().setName("Updated User Name");
            userService.updateUser(userToUpdate.get());
            logger.info("Updated User Data: " + userToUpdate);
        } else {
            logger.info("User with ID 1 not found.");
        }

//        SpringApplication.run(DemoApplication.class, args);
         context.close();
    }
}