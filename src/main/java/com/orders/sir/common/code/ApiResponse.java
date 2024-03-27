package com.orders.sir.common.code;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ApiResponse<T> {

    private LocalDateTime time = LocalDateTime.now();

    private String message;
    private String code;
    private int status;

    private T data;

    public ApiResponse(String message, String code, int status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

}
