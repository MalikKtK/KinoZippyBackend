package com.example.kinozippy.repository;

import com.example.kinozippy.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
