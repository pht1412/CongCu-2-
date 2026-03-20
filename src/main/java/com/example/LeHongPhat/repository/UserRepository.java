package com.example.LeHongPhat.repository;

import com.example.LeHongPhat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}