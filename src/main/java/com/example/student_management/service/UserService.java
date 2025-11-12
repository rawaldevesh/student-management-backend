package com.example.student_management.service;

import com.example.student_management.dto.CourseDTO;
import com.example.student_management.dto.UserDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.entity.User;
import com.example.student_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //register
    public User register(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Username already exists!");
        }
        return userRepository.save(user);

    }


    //login
    public UserDTO login(String username, String password) {
        User user = userRepository.findByUserName(username);

        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials!");
        }


        // Return limited data only (for frontend use)
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword()

        );
    }


    //get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getUserName(),user.getPassword()))
                .collect(Collectors.toList());
    }

    //fing by id
    public UserDTO findById(Long id){
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(null);
    }

    //edit users
    public User updateById(Long id, User updateUser){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUserName(updateUser.getUserName());
                    user.setPassword(updateUser.getPassword());

                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    public  void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword()

        );
    }




}
