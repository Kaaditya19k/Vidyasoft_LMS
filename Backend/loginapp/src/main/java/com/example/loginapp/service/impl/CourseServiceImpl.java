package com.example.loginapp.service.impl;

import com.example.loginapp.dto.CourseRequest;
import com.example.loginapp.dto.CourseResponse;
import com.example.loginapp.entity.Course;
import com.example.loginapp.repository.CourseRepository;
import com.example.loginapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest request) {

        Course course = Course.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .thumbnail(request.getThumbnail())
                .category(request.getCategory())
                .instructorName(request.getInstructorName())
                .totalLessons(request.getTotalLessons())
                .build();

        Course savedCourse = courseRepository.save(course);

        return mapToResponse(savedCourse);
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CourseResponse getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return mapToResponse(course);
    }

    @Override
    public List<CourseResponse> searchCourses(String keyword) {

        return courseRepository
                .findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<CourseResponse> getCoursesByCategory(String category) {

        return courseRepository
                .findByCategory(category)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private CourseResponse mapToResponse(Course course) {

        return CourseResponse.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .thumbnail(course.getThumbnail())
                .category(course.getCategory())
                .instructorName(course.getInstructorName())
                .totalLessons(course.getTotalLessons())
                .build();
    }
}