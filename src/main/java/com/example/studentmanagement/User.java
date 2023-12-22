package com.example.studentmanagement;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    int user_id;

    String user_name;

    String user_category;

    @ManyToMany(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_courses",joinColumns = @JoinColumn(referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "course_id"))
    Set<Course> courses = new HashSet<>();

    public User() {
    }

    public User(int user_id, String user_name, String user_category) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_category = user_category;
    }

    public User(int user_id, String user_name, String user_category, Set<Course> courses) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_category = user_category;
        this.courses = courses;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_category() {
        return user_category;
    }

    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_category='" + user_category + '\'' +
                ", courses=" + courses +
                '}';
    }
}
