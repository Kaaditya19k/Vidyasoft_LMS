package com.example.loginapp.service.impl;

import com.example.loginapp.dto.LessonResponse;
import com.example.loginapp.dto.PlaylistResponse;
import com.example.loginapp.dto.SectionResponse;
import com.example.loginapp.entity.Lesson;
import com.example.loginapp.entity.Section;
import com.example.loginapp.repository.LessonRepository;
import com.example.loginapp.repository.SectionRepository;
import com.example.loginapp.service.SectionService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final LessonRepository lessonRepository;

    @Override
    public PlaylistResponse getPlaylistBySection(Long sectionId) {

        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        List<Lesson> lessons = lessonRepository
                .findBySectionOrderByOrderNumberAsc(section);

        List<LessonResponse> lessonResponses = lessons
                .stream()
                .map(this::mapLessonToResponse)
                .toList();

        SectionResponse sectionResponse = SectionResponse.builder()
                .id(section.getId())
                .title(section.getTitle())
                .build();

        return PlaylistResponse.builder()
                .section(sectionResponse)
                .lessons(lessonResponses)
                .build();
    }

    private LessonResponse mapLessonToResponse(Lesson lesson) {

        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .videoUrl(lesson.getVideoUrl())
                .duration(lesson.getDuration())
                .thumbnail(lesson.getThumbnail())
                .orderNumber(lesson.getOrderNumber())
                .build();
    }
}