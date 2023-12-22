package com.example.studentmanagement.service;

import com.example.studentmanagement.Course;
import com.example.studentmanagement.User;

public interface CourseService {
    Course getCourseDetail(int id);

    Course saveDetails(Course c);

    Boolean deleteCourse(int id);
}
