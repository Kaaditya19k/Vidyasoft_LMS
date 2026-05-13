package com.example.loginapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseRequest {

    private String title;
    private String description;
    private String thumbnail;
    private String category;
    private String instructorName;
    private Integer totalLessons;
}