package com.example.student_management.controller;


import com.example.student_management.dto.CourseDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")

public class CourseController {

    @Autowired
    private CourseService courseService;


    //Adding The Course
    @PostMapping
    public Course add(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    // Get ALl Course
    @GetMapping
    public List<CourseDTO> getALlCourse(){
        return courseService.getAllCourses();
    }


    //get course by id or find
    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id){
        return courseService.findById(id);
    }

    //edit by id
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatecourse){
      return courseService.updateCourseById(id,updatecourse);
    }

    //delete  by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){

        try{
            courseService.deleteCourseById(id);
            return ResponseEntity.ok(
                    Map.of("message", "Teacher deleted successfully"));

        }
        catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }


}
