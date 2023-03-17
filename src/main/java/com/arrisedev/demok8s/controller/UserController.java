package com.arrisedev.demok8s.controller;

import com.arrisedev.demok8s.model.User;
import com.arrisedev.demok8s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/save/{id}")
    public ResponseEntity<User> saveUser(@RequestBody User user, @PathVariable Long id){
        return ResponseEntity.ok(service.createUser(user, id));
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<Optional<User>> fetchUser(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("fetch/all")
    public ResponseEntity<List<User>> fetchAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
}
