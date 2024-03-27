package com.orders.sir.common.code;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess {

    private static String headerName = "Content-Type";
    private static String headerValue = "application/json; charset=UTF-8";

    public static <T> ResponseEntity<ApiResponse<T>> of(T data) {

        return ResponseEntity.ok()
                .header(headerName, headerValue)
                .body(
                        new ApiResponse<T>(
                                "성공 하였습니다.",
                                "success",
                                200,
                                data
                        )
                );
    }

}
