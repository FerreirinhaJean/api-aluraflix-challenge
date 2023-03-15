package br.com.alurachallengejean.api.aluraflix.entities.dto;

import br.com.alurachallengejean.api.aluraflix.entities.Category;

public record CategoryDetailtedResponseDto(
        Long id,
        String title,
        String color
) {
    public CategoryDetailtedResponseDto(Category category) {
        this(category.getId(), category.getTitle(), category.getColor());
    }
}
