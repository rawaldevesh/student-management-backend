package com.example.student_management.controller;


import com.example.student_management.dto.CourseDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
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
    public String deleteCourse(@PathVariable Long id){
       courseService.deleteCourseById(id);
       return "Course Deleted Successfully";
    }


}
