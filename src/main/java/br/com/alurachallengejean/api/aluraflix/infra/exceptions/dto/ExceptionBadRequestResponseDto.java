package br.com.alurachallengejean.api.aluraflix.infra.exceptions.dto;

import org.springframework.validation.FieldError;

public record ExceptionBadRequestResponseDto(
        String field,
        String message
) {
    public ExceptionBadRequestResponseDto(FieldError exception) {
        this(exception.getField(), exception.getDefaultMessage());
    }
}
