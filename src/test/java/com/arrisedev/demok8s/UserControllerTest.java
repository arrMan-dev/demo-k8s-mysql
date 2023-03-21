package com.arrisedev.demok8s;

import com.arrisedev.demok8s.controller.UserController;
import com.arrisedev.demok8s.model.User;
import com.arrisedev.demok8s.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @Mock
    private UserServiceImpl impl;

    @Test
    void saveUserRequest(){
        User user = setUser();
        ResponseEntity<User> newUser= controller.saveUser(user, user.getId());
        assertNotNull(newUser);
    }

    @Test
    void shouldFetchUserPerId(){
        User user = setUser();
        ResponseEntity<Optional<User>> newUser = controller.fetchUser(user.getId());
        assertNotNull(newUser);
    }

    @Test
    void shouldListAllUsers(){
        User user = setUser();
        List<User> list = new ArrayList<>();
        list.add(user);
        when(impl.getAllUsers()).thenReturn(list);
        ResponseEntity<List<User>> listResponseEntity = controller.fetchAllUsers();
        assertNotNull(listResponseEntity);

    }
    private User setUser(){
        Long id = 100000000L;
        User user = new User();
        user.setId(id);
        user.setFirstName("Arris");
        user.setLastName("Manduma");
        user.setEmailId("arris@test.com");
        user.setPassword("Believeingod01!");
        user.setMsg("It should pass");

        return user;
    }
}
