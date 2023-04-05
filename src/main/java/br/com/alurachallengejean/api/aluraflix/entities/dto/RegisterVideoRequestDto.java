package br.com.alurachallengejean.api.aluraflix.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterVideoRequestDto(
        @NotBlank(message = "title is required")
        @Size(max = 120, message = "Maximum allowed length of 120 characters")
        String title,
        @NotBlank(message = "description is required")
        @Size(max = 400, message = "Maximum allowed length of 400 characters")
        String description,
        @NotBlank(message = "url is required")
        @Size(max = 300, message = "Maximum allowed length of 300 characters")
        String url,
        @JsonProperty("id_category")
        Long idCategory
) {
}
