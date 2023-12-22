package com.example.studentmanagement.serviceImpl;

import com.example.studentmanagement.Course;
import com.example.studentmanagement.User;
import com.example.studentmanagement.exceptions.UserNotFoundException;
import com.example.studentmanagement.repository.CourseRepository;
import com.example.studentmanagement.repository.UserRepository;
import com.example.studentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public User getUserDetail(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User saveDetails(User u){
        return userRepository.save(u);
    }

    @Override
    public Boolean deleteUser(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User newUser = userOptional.get();
            userRepository.delete(newUser);
            return true;
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public Boolean addCourseToUser(int id, int courseid) {
        Optional<User> user = userRepository.findById(id);
        Optional<Course> course = courseRepository.findById(courseid);
        if(user.isPresent()) {
            User u = user.get();
            Course c = course.get();
            u.getCourses().add(c);
            userRepository.save(u);
            return true;
        }
        throw new UserNotFoundException("User not found");
    }
}
