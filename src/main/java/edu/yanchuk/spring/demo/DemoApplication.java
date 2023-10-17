package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Access your beans from the application context
		UserService userService = context.getBean("userService", UserService.class);
		EventService eventService = context.getBean("eventService", EventService.class);
		TicketService ticketService = context.getBean("ticketService", TicketService.class);

		SpringApplication.run(DemoApplication.class, args);
	}

}
