package com.example.kinozippy.service;

import com.example.kinozippy.model.Movie;
import com.example.kinozippy.model.user.User;
import com.example.kinozippy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<User> postUser(User user) {
        if (doesUserExists(user)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        User postedUser = userRepository.save(user);
        return new ResponseEntity<>(postedUser, HttpStatus.OK);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<User> putUser(User user) {
        if (doesUserExists(user)) {
            User updatedUser = userRepository.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<User> deleteUser(long userId) {
        Optional<User> optinalUser = userRepository.findById(userId);
        if (doesUserExists(userId)) {
            User deletedUser = optinalUser.get();
            userRepository.deleteById(userId);
            return new ResponseEntity<>(deletedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    private boolean doesUserExists(User user) {
        Long userID = user.getId();
        return doesUserExists(userID);
    }
    private boolean doesUserExists(Long id) {
        boolean isIdSet = id != null;
        return isIdSet && userRepository.existsById(id);
    }

}
