package com.giantgame.controller.advice;

import com.giantgame.model.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionAdvice {

    private static final String SERVER_ERROR = "Internal Server Error";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorMessage handleClientError(Exception ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), new Date());
    }
}
