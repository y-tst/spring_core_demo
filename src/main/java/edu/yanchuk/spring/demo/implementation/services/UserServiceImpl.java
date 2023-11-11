package edu.yanchuk.spring.demo.implementation.services;

import edu.yanchuk.spring.demo.implementation.User;
import edu.yanchuk.spring.demo.interfaces.dao.UserDAO;
import edu.yanchuk.spring.demo.interfaces.services.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User getUserById(long userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDAO.deleteUser(userId);
    }
}
