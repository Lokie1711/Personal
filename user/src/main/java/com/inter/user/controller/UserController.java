package com.inter.user.controller;

import com.inter.user.entity.UserEntity;
import com.inter.user.repo.UserRepository;
import com.inter.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.getUserById(id);
    }

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
