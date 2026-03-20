package com.example.LeHongPhat.service;

import com.example.LeHongPhat.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User save(User user);
    Optional<User> getById(Long id);
    void delete(Long id);
}