package com.example.loginapp.repository;

import com.example.loginapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCategory(String category);

    List<Course> findByTitleContainingIgnoreCase(String keyword);
}