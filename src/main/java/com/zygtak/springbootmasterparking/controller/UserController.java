package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.entity.User;
import com.zygtak.springbootmasterparking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/userByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @GetMapping("/userLogin/{email}/{password}")
    public User getUserByEmail(@PathVariable String email, @PathVariable String password) {
        return service.getUserByEmailAndPassword(email, password);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}