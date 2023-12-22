package com.example.studentmanagement.serviceImpl;

import com.example.studentmanagement.Course;
import com.example.studentmanagement.exceptions.CourseNotFoundException;
import com.example.studentmanagement.repository.CourseRepository;
import com.example.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course getCourseDetail(int id){
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            if(course.getCourse_status()){
                return course;
            }
            throw new CourseNotFoundException("Course not found");
        }
        throw new CourseNotFoundException("Course not found");
    }

    @Override
    public Course saveDetails(Course c){
        return courseRepository.save(c);
    }

    @Override
    public Boolean deleteCourse(int id){
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            Course newCourse = courseOptional.get();
//            courseRepository.delete(newCourse);
            newCourse.setCourse_status(false);
            courseRepository.save(newCourse);
            return true;
        }
        throw new CourseNotFoundException("Course not found");
    }
}
