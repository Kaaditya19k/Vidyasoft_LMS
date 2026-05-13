package com.example.loginapp.service;

import com.example.loginapp.dto.CourseRequest;
import com.example.loginapp.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CourseRequest request);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    List<CourseResponse> searchCourses(String keyword);

    List<CourseResponse> getCoursesByCategory(String category);
}