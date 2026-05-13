package com.example.loginapp.controller;

import com.example.loginapp.dto.PlaylistResponse;
import com.example.loginapp.service.SectionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
@CrossOrigin("*")

public class SectionController {

    private final SectionService sectionService;

    @GetMapping("/{sectionId}/playlist")
    public PlaylistResponse getPlaylist(
            @PathVariable Long sectionId
    ) {

        return sectionService.getPlaylistBySection(sectionId);
    }
}