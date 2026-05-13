package com.example.loginapp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PlaylistResponse {

    private SectionResponse section;

    private List<LessonResponse> lessons;
}