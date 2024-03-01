package com.orders.sir.common.enums;

public enum ResponseMsg {

    SUCCESS("성공 하였습니다."),;
    private final String msg;

    ResponseMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
