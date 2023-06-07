package com.orders.sir.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.annotation.Repeatable;
import java.rmi.NotBoundException;

@RestControllerAdvice
public class MainRestControllerException {

    private final Logger logger = LoggerFactory.getLogger(MainRestControllerException.class);
    @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error("handleException" , e);
        ErrorResponse errorResponse = ErrorResponse
                                            .create()
                .code(ErrorCode.SERVER_ERROR.getCode())
                                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                            .message(e.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

  }

    @ExceptionHandler(NotBoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotBoundException(NotBoundException e) {
        logger.error("handleNotBoundException" , e);
        ErrorResponse errorResponse = ErrorResponse
                .create()
                .code(ErrorCode.NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<ErrorResponse> badRequestException(HttpClientErrorException.BadRequest e) {
        logger.error("badRequestException" , e);
        ErrorResponse errorResponse = ErrorResponse
                .create()
                .code(ErrorCode.BAD_REQUEST.getCode())
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ExceptionCustom.ApiException.class)
    protected ResponseEntity<ErrorResponse> apiException(HttpClientErrorException.BadRequest e) {
        logger.error("apiException" , e);
        ErrorResponse errorResponse = ErrorResponse
                .create()
                .code(ErrorCode.API_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
