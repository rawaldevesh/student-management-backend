package com.example.student_management.controller;


import com.example.student_management.dto.StudentDTO;

import com.example.student_management.entity.Student;
import com.example.student_management.entity.Teacher;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // GET ALL Students
    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getAllStudents();
    }

    // GET Student BY ID
    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    // UPDATE Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student) {
        return studentService.updateById(id,student);
    }

    // DELETE Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "Student deleted successfully";
    }

}
