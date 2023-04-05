package br.com.alurachallengejean.api.aluraflix.infra.exceptions;

import br.com.alurachallengejean.api.aluraflix.entities.dto.GenericResultResponseDto;
import br.com.alurachallengejean.api.aluraflix.infra.exceptions.dto.ExceptionBadRequestResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHanlderAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequestError(MethodArgumentNotValidException exception) {
        var exceptionBadRequestResponseDtos = exception.getFieldErrors().stream().map(ExceptionBadRequestResponseDto::new).toList();
        return ResponseEntity.badRequest().body(exceptionBadRequestResponseDtos);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        return new ResponseEntity(new GenericResultResponseDto("Not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionHandlerValidation.class)
    public ResponseEntity handleValidationException(ExceptionHandlerValidation exceptionHandlerValidation) {
        return ResponseEntity.badRequest().body(exceptionHandlerValidation.getMessage());
    }

}
