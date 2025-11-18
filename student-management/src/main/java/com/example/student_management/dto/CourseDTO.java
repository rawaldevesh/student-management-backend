package com.example.student_management.dto;

import java.util.List;

public class CourseDTO {

    private Long id;
    private String courseName;
    private String duration;

    private String teacherName;

//    private String departmentName;

    public CourseDTO(String name, String s, Long id, String courseName, String duration) {
    }

    public CourseDTO(Long id, String courseName, String duration, String teacherName) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.teacherName = teacherName;
//        this.departmentName = departmentName;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

//    public String getDepartmentName() {
//        return departmentName;
//    }

//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
}
