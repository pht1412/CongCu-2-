package com.example.LeHongPhat.controller;

import com.example.LeHongPhat.model.User;
import com.example.LeHongPhat.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService service;

    public UserApiController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        user.setCreatedAt(null); // 🔥 bắt buộc
        return service.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User newUser) {
        User u = service.getById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        u.setName(newUser.getName());
        u.setEmail(newUser.getEmail());
        u.setRole(newUser.getRole());
        u.setDateOfBirth(newUser.getDateOfBirth());
        u.setAddress(newUser.getAddress());
        u.setPhoneNumber(newUser.getPhoneNumber());

        if (newUser.getPassword() != null && !newUser.getPassword().isEmpty()) {
            u.setPassword(newUser.getPassword());
        }

        return service.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}