package com.springboot.cruddemo.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ConstraintViolationException.class)
    public String validationHandler(ConstraintViolationException ex){
        return "Enter Valid Input";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String notFound(NoSuchElementException ex){
        return ex.getMessage();
    }
}
