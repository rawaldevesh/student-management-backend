package com.example.student_management.service;


import com.example.student_management.dto.StudentDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //add Student
    public Student addStudent(Student student){
      return studentRepository.save(student);
    }

    //get All Student
    public List<StudentDTO> getAllStudent(){
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //find By Id
    public StudentDTO findById(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    //update by id
    public Student updateById(Long id,Student updateStudent){
        if (updateStudent.getTeacher() == null || updateStudent.getCourse() == null) {
            throw new IllegalArgumentException("Teacher and Department Can not be Null");
        }
        return  studentRepository.findById(id)
                .map(student -> {
                    student.setEmail(updateStudent.getEmail());
                    student.setName(updateStudent.getName());
                    student.setAddress(updateStudent.getAddress());
                    student.setTeacher(updateStudent.getTeacher());
                    student.setCourse(updateStudent.getCourse());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new RuntimeException("Student not found id: "+id));
    }

    //delete by id
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);

    }

    private StudentDTO convertToDTO(Student student){

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getAddress(),
                student.getTeacher().getName(),
                student.getCourse().getCourseName()
        );
    }
}
