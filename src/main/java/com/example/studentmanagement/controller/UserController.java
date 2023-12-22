package com.example.studentmanagement.controller;


import com.example.studentmanagement.Course;
import com.example.studentmanagement.User;
import com.example.studentmanagement.service.UserService;
import com.example.studentmanagement.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserDetail(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestParam int user_id, @RequestParam String user_name, @RequestParam String user_category){
        User u = new User(user_id, user_name, user_category);

        return userService.saveDetails(u);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("{id}/{courseid}")
    public Boolean addCourseToUser(@PathVariable int id, @PathVariable int courseid){
        return userService.addCourseToUser(id, courseid);
    }
}
