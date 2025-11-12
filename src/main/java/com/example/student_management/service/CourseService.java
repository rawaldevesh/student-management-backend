package com.example.student_management.service;

import com.example.student_management.dto.CourseDTO;
import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.entity.Teacher;
import com.example.student_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    //add Course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }


    //get All Course
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //get by id or find by id
    public CourseDTO findById(Long id){
        return courseRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }





    //update by id
    public Course updateCourseById(Long id, Course updateCourse){
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourseName(updateCourse.getCourseName());
                    course.setDuration(updateCourse.getDuration());
                    course.setTeacher(updateCourse.getTeacher());
                    course.setDepartment(updateCourse.getDepartment());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new RuntimeException("Course Not found id: " + id));
    }

    //delete Course
    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }


    private CourseDTO convertToDTO(Course course) {
        String teacherName = course.getTeacher() != null ? course.getTeacher().getName() : "Unassigned";
        String departmentName = course.getDepartment() != null ? course.getDepartment().getName() : "Unassigned";

        return new CourseDTO(
                course.getId(),
                course.getCourseName(),
                course.getDuration(),
                teacherName,
                departmentName
        );
    }
}
