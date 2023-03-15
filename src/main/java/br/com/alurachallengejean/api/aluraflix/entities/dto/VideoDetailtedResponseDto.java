package br.com.alurachallengejean.api.aluraflix.entities.dto;

import br.com.alurachallengejean.api.aluraflix.entities.Video;

public record VideoDetailtedResponseDto(
        Long id,
        String title,
        String description,
        String url
) {
    public VideoDetailtedResponseDto(Video video) {
        this(video.getId(), video.getTitle(), video.getDescription(), video.getUrl());
    }
}
