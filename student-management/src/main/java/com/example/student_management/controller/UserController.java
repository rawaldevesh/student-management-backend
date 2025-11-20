package com.example.student_management.controller;


import com.example.student_management.dto.UserDTO;
import com.example.student_management.entity.User;

import com.example.student_management.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    //register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest, HttpSession session) {


        try {
            UserDTO userDTO = userService.login(
                    loginRequest.getUserName(),
                    loginRequest.getPassword()
            );



            session.setAttribute("userId", userDTO.getId());
            session.setAttribute("username", userDTO.getUserName());

            return ResponseEntity.ok(userDTO);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", ex.getMessage()));
        }
    }


    @GetMapping("/check-login")
    public ResponseEntity<?> checkLogin(HttpSession session) {

        if (session.getAttribute("userId") != null) {
            return ResponseEntity.ok("LoggedIn");
        } else {
            return ResponseEntity.status(401).body("NotLoggedIn");
        }
    }

    //logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("Logged out");
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