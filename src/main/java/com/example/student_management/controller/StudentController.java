package com.example.student_management.controller;


import com.example.student_management.dto.StudentDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create Students
    @PostMapping
    public Student addstudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //Get all students
    @GetMapping
    public List<StudentDTO> getAll(){
        return studentService.getAllStudent();
    }

    //get student by id
    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id){
        return studentService.findById(id);
    }



    //edit or update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student upadateStudent){
        return studentService.updateById(id, upadateStudent);
    }




    //DELETE STUDENT
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "Student Deleted successfully";
    }

}
