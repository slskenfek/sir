package com.orders.sir.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ErrorResponse {

    private LocalDateTime localDateTime = LocalDateTime.now();

    private String message;
    private String code;
    private int status;

     public static ErrorResponse create() {
        return new ErrorResponse();
    }
    public ErrorResponse code(String code) {
         this.code = code;
         return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }




}
