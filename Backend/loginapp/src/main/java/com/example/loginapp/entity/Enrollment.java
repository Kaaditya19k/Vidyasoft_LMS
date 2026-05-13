package com.example.loginapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enrollments")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}