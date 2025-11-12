package com.example.student_management.repository;


import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {


    List<Student> findByName(String name);

}
