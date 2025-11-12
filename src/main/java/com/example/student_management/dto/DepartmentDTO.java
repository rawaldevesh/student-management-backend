package com.example.student_management.dto;

public class DepartmentDTO {

    private Long id;
    private String name;          // e.g. Computer Science
    private String code;          // e.g. CSE

    private String hodName;       // Head of Department

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name,String code, String hodName) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.hodName = hodName;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
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
}
