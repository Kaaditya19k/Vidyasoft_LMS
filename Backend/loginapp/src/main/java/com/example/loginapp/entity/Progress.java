package com.example.loginapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "progress")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean completed;

    private Integer watchedDuration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}