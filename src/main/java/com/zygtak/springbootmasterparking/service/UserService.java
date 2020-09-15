package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.entity.User;
import com.zygtak.springbootmasterparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User " + id + " removed";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return repository.save(existingUser);
    }
}
