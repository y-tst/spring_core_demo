package edu.yanchuk.spring.demo.interfaces.dao;

import edu.yanchuk.spring.demo.implementation.User;

import java.util.List;

public interface UserDAO {

    User createUser(User user);
    User getUserById(long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(long userId);
}
