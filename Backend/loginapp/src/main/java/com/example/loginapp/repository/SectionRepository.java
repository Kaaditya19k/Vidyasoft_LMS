package com.example.loginapp.repository;

import com.example.loginapp.entity.Course;
import com.example.loginapp.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {

    List<Section> findByCourse(Course course);
}