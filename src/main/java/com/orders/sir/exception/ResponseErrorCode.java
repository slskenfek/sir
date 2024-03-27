package com.orders.sir.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ResponseErrorCode {

    private LocalDateTime localDateTime = LocalDateTime.now();

    private String message;
    private String code;
    private int status;

     public static ResponseErrorCode create() {
        return new ResponseErrorCode();
    }
    public ResponseErrorCode code(String code) {
         this.code = code;
         return this;
    }

    public ResponseErrorCode status(int status) {
        this.status = status;
        return this;
    }

    public ResponseErrorCode message(String message) {
        this.message = message;
        return this;
    }

}
