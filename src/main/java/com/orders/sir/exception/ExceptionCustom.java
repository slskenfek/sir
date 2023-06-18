package com.orders.sir.exception;

import org.springframework.http.HttpStatus;

public class ExceptionCustom {

    public static class ApiException extends RuntimeException {
        private String msg;
        private HttpStatus httpStatus;

        public ApiException(String msg, HttpStatus httpStatus) {
            this.msg = msg;
            this.httpStatus = httpStatus;
        }
    }

    public static class ValidationException extends RuntimeException{
        public ValidationException(String message) {
            super(message);
        }
    }






}
