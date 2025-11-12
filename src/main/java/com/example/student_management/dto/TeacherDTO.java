package com.example.student_management.dto;

import com.example.student_management.entity.Course;
import com.example.student_management.entity.Department;

import java.util.List;

public class TeacherDTO {

    private Long id;

    private String name;


    private String email;
    private String phoneNumber;
    private String departmentName;
    private List<String> courses;

    public TeacherDTO() {
    }

    public TeacherDTO(List<String> courses, String departmentName, String email, Long id, String name, String phoneNumber) {
        this.courses = courses;
        this.departmentName = departmentName;
        this.email = email;
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
