package com.example.studentmanagement.controller;

import com.example.studentmanagement.Course;
import com.example.studentmanagement.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourseDetail(id);
    }

    @PostMapping("/")
    public Course saveCourse(@RequestParam int course_id, @RequestParam String course_name, @RequestParam int course_fee){
        Course c = new Course(course_id, course_name, course_fee);

        return courseService.saveDetails(c);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
}
