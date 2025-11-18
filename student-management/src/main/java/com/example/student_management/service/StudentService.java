package com.example.student_management.service;


import com.example.student_management.dto.StudentDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    // CREATE Student
    public Student addStudent(Student student) {

      return studentRepository.save(student);
    }


    // GET ALL
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // GET BY ID
    public StudentDTO findById(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }


    // UPDATE Student
    public Student updateById(Long id, Student updateStudent) {
        if (updateStudent.getCourse() == null) {
            throw new IllegalArgumentException("Course cannot be null for a teacher.");
        }
        return studentRepository.findById(id)
                .map(student -> {

                    student.setName(updateStudent.getName());
                    student.setEmail(updateStudent.getEmail());
                    student.setPhone(updateStudent.getPhone());
                    student.setAddress(updateStudent.getAddress());
                    student.setCourse(updateStudent.getCourse());
                    Student updated = studentRepository.save(student);

                    return studentRepository.save(student);

                }).orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }


    // DELETE
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


    // CONVERTER: Student -> StudentDTO
    private StudentDTO convertToDTO(Student student) {

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getAddress(),
                student.getCourse().getCourseName());
    }
}
