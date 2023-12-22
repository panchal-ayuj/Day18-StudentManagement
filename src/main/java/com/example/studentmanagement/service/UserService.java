package com.example.studentmanagement.service;

import com.example.studentmanagement.Course;
import com.example.studentmanagement.User;

public interface UserService {
    User getUserDetail(int id);

    User saveDetails(User u);

    Boolean deleteUser(int id);

    Boolean addCourseToUser(int id, int courseid);
}
