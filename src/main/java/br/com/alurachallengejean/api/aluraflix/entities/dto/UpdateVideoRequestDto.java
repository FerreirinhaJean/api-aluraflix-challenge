package br.com.alurachallengejean.api.aluraflix.entities.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateVideoRequestDto(
        @NotNull(message = "id is required")
        Long id,
        @Size(max = 120, message = "Maximum allowed length of 120 characters")
        @Size(min = 1, message = "Update title not must blank")
        String title,
        @Size(max = 400, message = "Maximum allowed length of 400 characters")
        @Size(min = 1, message = "Update description not must blank")
        String description,
        @Size(max = 300, message = "Maximum allowed length of 300 characters")
        @Size(min = 1, message = "Update url not must blank")
        String url
) {
}
