package com.arrisedev.demok8s;

import com.arrisedev.demok8s.model.User;
import com.arrisedev.demok8s.repository.UserRepository;
import com.arrisedev.demok8s.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl impl;

    @Mock
    private UserRepository repository;

    @Test
    void itShouldSaveUser(){
        User user = setUser();
        when(repository.save(user)).thenReturn(user);
        User newUser = impl.createUser(user, user.getId());
        assertNotNull(newUser);
    }

    @Test
    void shouldGetUserById(){
        User user = setUser();
        Optional<User> newUser = impl.getUserById(user.getId());
        assertNotNull(newUser);

    }

    @Test
    void shouldGetList(){
        User user = setUser();
        List<User> newUser = new ArrayList<>();
        newUser.add(user);
        newUser = impl.getAllUsers();
        assertNotNull(newUser);
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
