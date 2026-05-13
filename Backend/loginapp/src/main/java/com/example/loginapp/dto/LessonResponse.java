package com.example.loginapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LessonResponse {

    private Long id;

    private String title;

    private String videoUrl;

    private String duration;

    private String thumbnail;

    private Integer orderNumber;
}