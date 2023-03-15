package br.com.alurachallengejean.api.aluraflix.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterCategoryRequestDto(
        @NotBlank(message = "title is requered")
        @Size(max = 120, message = "Maximum allowed length of 120 characters")
        String title,
        @NotBlank(message = "color is requered")
        @Size(max = 20, message = "Maximum allowed length of 20 characters")
        String color
) {
}
