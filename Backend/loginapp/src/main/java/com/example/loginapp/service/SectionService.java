package com.example.loginapp.service;

import com.example.loginapp.dto.PlaylistResponse;

public interface SectionService {

    PlaylistResponse getPlaylistBySection(Long sectionId);
}