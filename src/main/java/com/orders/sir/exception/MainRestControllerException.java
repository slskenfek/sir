package com.orders.sir.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.NotBoundException;

@RestControllerAdvice
public class MainRestControllerException {

    private final Logger logger = LoggerFactory.getLogger(MainRestControllerException.class);
    @ExceptionHandler(Exception.class)
  protected ResponseEntity<ResponseErrorCode> handleException(Exception e) {
        logger.error("handleException" , e);
        ResponseErrorCode responseErrorCode = ResponseErrorCode
                                            .create()
                .code(ErrorCode.SERVER_ERROR.getCode())
                                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                            .message(e.toString());

        return new ResponseEntity<>(responseErrorCode, HttpStatus.INTERNAL_SERVER_ERROR);

  }

    @ExceptionHandler(NotBoundException.class)
    protected ResponseEntity<ResponseErrorCode> handleNotBoundException(NotBoundException e) {
        logger.error("handleNotBoundException" , e);
        ResponseErrorCode responseErrorCode = ResponseErrorCode
                .create()
                .code(ErrorCode.NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.toString());

        return new ResponseEntity<>(responseErrorCode, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<ResponseErrorCode> badRequestException(HttpClientErrorException.BadRequest e) {
        logger.error("badRequestException" , e);
        ResponseErrorCode responseErrorCode = ResponseErrorCode
                .create()
                .code(ErrorCode.BAD_REQUEST.getCode())
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.toString());

        return new ResponseEntity<>(responseErrorCode, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ExceptionCustom.ApiException.class)
    protected ResponseEntity<ResponseErrorCode> apiException(ExceptionCustom.ApiException e) {
        logger.error("apiException" , e);
        ResponseErrorCode responseErrorCode = ResponseErrorCode
                .create()
                .code(ErrorCode.API_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.toString());

        return new ResponseEntity<>(responseErrorCode, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ExceptionCustom.ValidationException.class)
    protected ResponseEntity<ResponseErrorCode> validationExceptionException(ExceptionCustom.ValidationException e) {
        logger.error("ValidationException" , e);
        ResponseErrorCode responseErrorCode = ResponseErrorCode
                .create()
                .code(ErrorCode.VALIDATION_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.toString());

        return new ResponseEntity<>(responseErrorCode, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
