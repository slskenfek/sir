package com.orders.sir.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ErrorCode {

    BAD_REQUEST("CO01","Bad Reqeust 요청 리퀘스트 확인", 400),
    NOT_FOUND("CO02","요청된 주소가 존재하지 않습니다.", 404),
    SERVER_ERROR("CO03","서버 수행중 에러 발행", 500),
    API_ERROR("CO04","API 수행중 에러 발행", 500),
    VALIDATION_ERROR("CO05","유효성 체크중 에러 발생", 500),
    ;

    private String code;
    private String message;
    private int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
