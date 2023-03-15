package br.com.alurachallengejean.api.aluraflix.infra.exceptions;

import br.com.alurachallengejean.api.aluraflix.infra.exceptions.dto.ExceptionBadRequestResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHanlderAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequestError(MethodArgumentNotValidException exception) {
        var exceptionBadRequestResponseDtos = exception.getFieldErrors().stream().map(ExceptionBadRequestResponseDto::new).toList();
        return ResponseEntity.badRequest().body(exceptionBadRequestResponseDtos);
    }

}
