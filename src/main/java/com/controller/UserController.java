package com.controller;

import com.model.User;
import com.model.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  Collection<User> users() {
    return userRepository.findAll();
  }

  @CrossOrigin
  @PostMapping("/users")
  ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        User result = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/users/" + result.getId()))
                .body(result);
    }



}
