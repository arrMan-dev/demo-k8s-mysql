package com.arrisedev.demok8s.service;

import com.arrisedev.demok8s.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User newUser, Long id);
    Optional<User> getUserById(Long id);

    List<User> getAllUsers();
}
