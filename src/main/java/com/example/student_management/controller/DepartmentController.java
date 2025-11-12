package com.example.student_management.controller;

import com.example.student_management.dto.DepartmentDTO;
import com.example.student_management.entity.Department;
import com.example.student_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    //create
    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return  departmentService.AddDepartment(department);
    }

    //get all department

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    //get by id
    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: "+id));
    }

    //update or edit
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updateDepartment){
        return departmentService.updateDepartment(id, updateDepartment);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteDep(@PathVariable Long id){
        boolean deleted =  departmentService.deleteDepartment(id);
        return deleted ? "Department Deleted ": "Department not Found";
    }
}
