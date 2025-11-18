package com.example.student_management.dto;

import java.util.List;

public class StudentDTO {


    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;


    private String courseName;


    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, String phone, String address, String courseName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.courseName = courseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getTeacherName() {
//        return teacherName;
//    }
//
//    public void setTeacherName(String teacherName) {
//        this.teacherName = teacherName;
//    }
}
