package edu.yanchuk.spring.demo.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.yanchuk.spring.demo.interfaces.services.EventService;
import edu.yanchuk.spring.demo.interfaces.services.TicketService;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Storage implements InitializingBean {
    private String dataFilePath;
    private Map<String, Object> dataMap = new ConcurrentHashMap<>();

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserService userService = context.getBean("userService", UserService.class);
    EventService eventService = context.getBean("eventService", EventService.class);
    TicketService ticketService = context.getBean("ticketService", TicketService.class);

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    @Autowired
    private ObjectMapper objectMapper;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataFilePath != null) {
            try {
                Files.lines(Paths.get(dataFilePath)).forEach(line -> {
                    int colonIndex = line.indexOf(":");
                    if (colonIndex > 0) {
                        String key = line.substring(0, colonIndex).trim();
                        String value = line.substring(colonIndex + 1).trim();

                        if (key.startsWith("user")) {
                            processUser(value);
                        } else if (key.startsWith("event")) {
                            processEvent(value);
                        } else if (key.startsWith("ticket")) {
                            processTicket(value);
                        }
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException("Error reading data from the file", e);
            }
        }
    }

    private void processUser(String value) {
        // Handle user data
        try {
            User user = objectMapper.readValue(value, User.class);
            userService.createUser(user);
            dataMap.put("user " + user.getId(), user);
            System.out.println("Processed User Data: " + user);
        } catch (JsonProcessingException e) {
            // Handle the exception
        }
    }

    private void processEvent(String value) {
        // Handle event data
        try {
            Event event = objectMapper.readValue(value, Event.class);
            eventService.createEvent(event);
            dataMap.put("event " + event.getId(), event);
            System.out.println("Processed Event Data: " + event);
        } catch (JsonProcessingException e) {
            // Handle the exception
        }
    }

    private void processTicket(String value) {
        // Handle ticket data
        try {
            Ticket ticket = objectMapper.readValue(value, Ticket.class);
            ticketService.bookTicket(ticket.getUserId(), ticket.getEventId(), ticket.getSeat());
            dataMap.put("ticket " + ticket.getId(), ticket);
            System.out.println("Processed Ticket Data: " + ticket);
        } catch (JsonProcessingException e) {
            // Handle the exception
        }
    }

}
