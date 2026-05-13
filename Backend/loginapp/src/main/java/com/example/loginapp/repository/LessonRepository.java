package com.example.loginapp.repository;

import com.example.loginapp.entity.Lesson;
import com.example.loginapp.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findBySectionOrderByOrderNumberAsc(Section section);
}