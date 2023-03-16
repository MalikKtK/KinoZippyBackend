package com.example.kinozippy.controller;

import com.example.kinozippy.exception.ResourceNotFoundException;
import com.example.kinozippy.model.Movie;
import com.example.kinozippy.model.enums.AgeLimit;
import com.example.kinozippy.model.enums.Category;
import com.example.kinozippy.model.enums.Role;
import com.example.kinozippy.model.user.User;
import com.example.kinozippy.repository.UserRepository;
import com.example.kinozippy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/roles")
    public List<Role> getRoles() {
        return Role.getAllRoles();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id).orElseThrow( ()-> new ResourceNotFoundException("Movie with id: " + id));
    }
}
