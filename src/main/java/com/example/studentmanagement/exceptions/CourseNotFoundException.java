package com.example.studentmanagement.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message){
        super(message);
    }
}
