package br.com.alurachallengejean.api.aluraflix.entities.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateCategoryRequestDto(
        @NotNull(message = "id is required")
        Long id,
        @Size(max = 120, message = "Maximum allowed length of 120 characters")
        @Size(min = 1, message = "Update title not must blank")
        String title,
        @Size(max = 20, message = "Maximum allowed length of 20 characters")
        @Size(min = 1, message = "Update color not must blank")
        String color
) {
}
