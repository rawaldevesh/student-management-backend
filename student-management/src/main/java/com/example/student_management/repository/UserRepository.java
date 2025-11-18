package com.example.student_management.repository;

import com.example.student_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

        User findByUserName(String userName);
}
