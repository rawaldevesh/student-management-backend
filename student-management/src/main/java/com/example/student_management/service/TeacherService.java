package com.example.student_management.service;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.entity.Teacher;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private CourseRepository courseRepository;

    // add teacher
    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //get all teacher
    public List<TeacherDTO> getAllTeachers(){
        return teacherRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //get by id
    public TeacherDTO findById(Long id) {
        return teacherRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    //edit or update
    public Teacher updateTeacher(Long id, Teacher updateTeacher) {
        if (updateTeacher.getDepartment() == null) {
            throw new IllegalArgumentException("Department cannot be null for a teacher.");
        }
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(updateTeacher.getName());
                    teacher.setEmail(updateTeacher.getEmail());
                    teacher.setDepartment(updateTeacher.getDepartment());
                    teacher.setCourse(updateTeacher.getCourse());
                    teacher.setPhoneNumber(updateTeacher.getPhoneNumber());
                    return teacherRepository.save(teacher);
                }).orElseThrow(() -> new RuntimeException("Teacher Not found id: " + id));
    }

    //delete
    public void deleteTeacher(Long id){
        int courseCount = courseRepository.countByTeacherId(id);

        if (courseCount > 0) {
            throw new RuntimeException(
                    "Cannot delete teacher. This teacher is assigned to " + courseCount + " course."
            );
        }

        teacherRepository.deleteById(id);
    }

    private TeacherDTO convertToDTO(Teacher teacher){
        return new TeacherDTO(
                teacher.getCourse().stream()
                        .map(Course::getCourseName)
                        .collect(Collectors.toList()),          // courses
                teacher.getDepartment().getName(),            // departmentName
                teacher.getEmail(),                           // email
                teacher.getId(),                              // id
                teacher.getName(),                            // name
                teacher.getPhoneNumber()

        );
    }
}
