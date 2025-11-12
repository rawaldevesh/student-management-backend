//package com.example.student_management.controller;
//
//
//import com.example.student_management.dto.UserDTO;
//import com.example.student_management.entity.User;
//import com.example.student_management.repository.UserRepository;
//import com.example.student_management.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*")
//public class AuthController {
//
//    @Autowired
//   private UserService userService;
//
//    //Register USer
//    @PostMapping("register")
//    public UserDTO registration(@RequestBody User user){
//        return userService.register(user);
//    }
//
//    //login
//    @PostMapping("/login")
//    public String login(@RequestBody User user){
//        return userService.login(user.getUserName(),user.getPassword());
//    }
//
//}
