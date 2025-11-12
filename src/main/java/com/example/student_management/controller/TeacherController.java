package com.example.student_management.controller;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.entity.Teacher;
import com.example.student_management.repository.TeacherRepository;
import com.example.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //add
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    //get all
    @GetMapping
    public List<TeacherDTO> getAll(){
        return teacherService.getAllTeachers();
    }

    //get by id
    @GetMapping("/{id}")
    public TeacherDTO getById(@PathVariable Long id){
        return teacherService.findById(id);
    }

    //edit by id
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
            return teacherService.updateTeacher(id,teacher);
    }

    //delete by id
    @DeleteMapping("{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return "Teacher Deleted Successfully";
    }
}
