package com.arrisedev.demok8s.repository;

import com.arrisedev.demok8s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
