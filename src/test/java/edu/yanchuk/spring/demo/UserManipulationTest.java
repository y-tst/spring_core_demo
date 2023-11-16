package edu.yanchuk.spring.demo;

import edu.yanchuk.spring.demo.implementation.User;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserManipulationTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void CreateNewUserTest() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.getAllUsers().forEach(System.out::println);
        userService.createUser(new User(555l, "Elvis Presley", "Elvis555@example.com"));
        userService.getAllUsers().forEach(System.out::println);

        String lastAddedUser =  userService.getAllUsers().get(userService.getAllUsers().size() - 1).getName();

        logger.info("The user added in the end of map");

        assertEquals("Elvis Presley", lastAddedUser);
        userService.getAllUsers().forEach(System.out::println);

        Long userToUpdateId = userService.getAllUsers().get(userService.getAllUsers().size() - 1).getId();

        logger.info("Let's change his email and name (his ID now is {}):", userToUpdateId);

        User userToUpdate = new User(userToUpdateId, "Updated User Name", "updated_email@test.com");
        userService.updateUser(userToUpdate);
        logger.info("User with ID {} is updated.", userToUpdateId);
        userService.getAllUsers().forEach(System.out::println);

        context.close();
    }
}
