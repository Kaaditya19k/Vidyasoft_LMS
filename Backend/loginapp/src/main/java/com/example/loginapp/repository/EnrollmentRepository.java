package com.example.loginapp.repository;

import com.example.loginapp.entity.Course;
import com.example.loginapp.entity.Enrollment;
import com.example.loginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByUserAndCourse(User user, Course course);
}