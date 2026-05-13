package com.example.loginapp.controller;

import com.example.loginapp.dto.CourseRequest;
import com.example.loginapp.dto.CourseResponse;
import com.example.loginapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor

@CrossOrigin("*")

public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponse createCourse(
            @RequestBody CourseRequest request
    ) {

        return courseService.createCourse(request);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(
            @PathVariable Long id
    ) {

        return courseService.getCourseById(id);
    }

    @GetMapping("/search")
    public List<CourseResponse> searchCourses(
            @RequestParam String keyword
    ) {

        return courseService.searchCourses(keyword);
    }

    @GetMapping("/category/{category}")
    public List<CourseResponse> getCoursesByCategory(
            @PathVariable String category
    ) {

        return courseService.getCoursesByCategory(category);
    }
}