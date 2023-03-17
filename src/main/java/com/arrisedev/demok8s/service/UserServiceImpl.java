package com.arrisedev.demok8s.service;

import com.arrisedev.demok8s.model.User;
import com.arrisedev.demok8s.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User newUser, Long userId) {
        boolean userOptional;
        if (userRepository.existsById(userId)) userOptional = true;
        else userOptional = false;
        if (userOptional == false) return userRepository.save(newUser);
        else return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
