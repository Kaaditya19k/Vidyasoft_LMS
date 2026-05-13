package com.example.loginapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseResponse {

    private Long id;

    private String title;

    private String description;

    private String thumbnail;

    private String category;

    private String instructorName;

    private Integer totalLessons;
}