package com.arrisedev.demok8s;

import com.arrisedev.demok8s.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTest {

    @Test
    void shouldCreateUser(){
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setFirstName("Arris");
        user.setLastName("Manduma");
        user.setEmailId("arris@test.com");
        user.setPassword("Believeingod01!");
        user.setMsg("It should pass");

        assertNotNull(user);
    }
}
