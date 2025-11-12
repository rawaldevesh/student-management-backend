package com.example.student_management.controller;


import com.example.student_management.dto.UserDTO;
import com.example.student_management.entity.User;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // allow frontend (VS Code server) to access
public class UserController {

    @Autowired
    private UserService userService;

    //register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    //login
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        UserDTO userDTO = userService.login(loginRequest.getUserName(), loginRequest.getPassword());
        return "Login successful! Welcome, " + userDTO.getUsername() + ")";
    }

    //get all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // get by id
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    //update by id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }

    // delet by id
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User deleted successfully!";
    }


}