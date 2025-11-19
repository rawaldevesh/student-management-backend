package com.example.student_management.controller;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.entity.Teacher;
import com.example.student_management.repository.TeacherRepository;
import com.example.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teachers")
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
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id){

        try{
        teacherService.deleteTeacher(id);
            return ResponseEntity.ok(
                    Map.of("message", "Teacher deleted successfully"));

        }
        catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
