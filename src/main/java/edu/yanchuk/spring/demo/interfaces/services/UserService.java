package edu.yanchuk.spring.demo.interfaces.services;

import edu.yanchuk.spring.demo.implementation.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(long userId);
}
