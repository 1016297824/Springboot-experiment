package com.example.experiment05.practise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class Controller_Advice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handleValidException(MethodArgumentNotValidException exception){
        StringBuilder strBuilder=new StringBuilder();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e->{
                    strBuilder.append(e.getField());
                    strBuilder.append(":");
                    strBuilder.append(e.getDefaultMessage());
                    strBuilder.append(":");
                });
        return Map.of("message",strBuilder.toString()+" ");
    }
}