package com.example.loginapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String videoUrl;

    private String duration;

    private String thumbnail;

    private Integer orderNumber;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}