package com.example.student_management.service;

import com.example.student_management.dto.DepartmentDTO;
import com.example.student_management.entity.Department;
import com.example.student_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    //add dep
    public Department AddDepartment(Department department){
       return departmentRepository.save(department);
    }

    //get all department
    public List<DepartmentDTO> getAllDepartments(){
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //find by id
    public Optional<DepartmentDTO> getDepartmentById(Long id){
        return departmentRepository.findById(id).map(this::convertToDTO);
    }

    //edit
    public Department updateDepartment(Long id, Department updateDepartment){
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(updateDepartment.getName());
                    department.setCode(updateDepartment.getCode());
                    department.setHodName(updateDepartment.getHodName());
                    return departmentRepository.save(department);
                })
                .orElseThrow(() -> new RuntimeException("Department Not found id : "+id));
    }

    //delete
    public boolean deleteDepartment(Long id){
        if(departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    private DepartmentDTO convertToDTO(Department department) {
            return new DepartmentDTO(
                    department.getId(),
                    department.getName(),
                    department.getCode(),
                    department.getHodName()
            );
    }

}
