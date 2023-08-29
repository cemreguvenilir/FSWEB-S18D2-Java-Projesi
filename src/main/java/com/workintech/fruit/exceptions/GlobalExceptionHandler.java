package com.workintech.fruit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(FruitException exception){
        FruitResponse response = new FruitResponse(exception.getStatus().value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, exception.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(Exception exception){
        FruitResponse response = new FruitResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            Map<String, String> errors = new HashMap<>();
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errors;
        }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }
}
