package com.example.loginapp.repository;

import com.example.loginapp.entity.Lesson;
import com.example.loginapp.entity.Progress;
import com.example.loginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserAndLesson(User user, Lesson lesson);
}