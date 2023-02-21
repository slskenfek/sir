package com.orders.sir.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Repeatable;

@RestControllerAdvice
public class MainRestControllerException {

    private final Logger logger = LoggerFactory.getLogger(MainRestControllerException.class);
    @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error("handleException" , e);
        ErrorResponse errorResponse = ErrorResponse
                                            .create()
                                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                            .message(e.toString());


        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

  }

}
