package com.example.studentmanagement;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int course_id;

    String course_name;

    int course_fee;

    Boolean course_status;

    @ManyToMany(targetEntity = User.class,mappedBy = "courses")
    Set<User> userSet = new HashSet<>();

    public Boolean getCourse_status() {
        return course_status;
    }

    public void setCourse_status(Boolean course_status) {
        this.course_status = course_status;
    }

    public Course() {
    }

    public Course(int course_id, String course_name, int course_fee) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_fee = course_fee;
        this.course_status = true;
    }

    public Course(int course_id, String course_name, int course_fee, Set<User> userSet) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_fee = course_fee;
        this.userSet = userSet;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(int course_fee) {
        this.course_fee = course_fee;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_fee=" + course_fee +
                ", course_status=" + course_status +
                ", userSet=" + userSet +
                '}';
    }
}
