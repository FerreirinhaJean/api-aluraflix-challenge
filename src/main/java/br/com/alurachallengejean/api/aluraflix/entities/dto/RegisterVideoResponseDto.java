package br.com.alurachallengejean.api.aluraflix.entities.dto;

import br.com.alurachallengejean.api.aluraflix.entities.Video;

public record RegisterVideoResponseDto(
        Long id,
        String title,
        String description,
        String url
) {
    public RegisterVideoResponseDto(Video video) {
        this(video.getId(), video.getTitle(), video.getDescription(), video.getUrl());
    }
}
