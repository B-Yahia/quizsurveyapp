package com.example.quizsurveyapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionsHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidData (MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String,String> handleNotFoundEx (ResourceNotFoundException exception){
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("Messages", exception.getMessage());
        return  errorMsg;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityException.class)
    public Map<String,String> handleDataIntegrityEx (DataIntegrityException exception){
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("Messages", exception.getMessage());
        return  errorMsg;
    }
}
