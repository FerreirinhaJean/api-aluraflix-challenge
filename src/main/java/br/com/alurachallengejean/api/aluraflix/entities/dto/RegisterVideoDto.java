package br.com.alurachallengejean.api.aluraflix.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterVideoDto(
        @NotBlank
        @Size(max = 120, message = "Maximum allowed length of 120 characters")
        String title,
        @NotBlank
        @Size(max = 400, message = "Maximum allowed length of 400 characters")
        String description,
        @NotBlank
        @Size(max = 300, message = "Maximum allowed length of 300 characters")
        String url
) {
}
