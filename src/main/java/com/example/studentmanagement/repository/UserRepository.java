package com.example.studentmanagement.repository;

import com.example.studentmanagement.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
