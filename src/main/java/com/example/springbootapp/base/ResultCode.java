package com.example.springbootapp.base;

public enum ResultCode {
    SUCCESSFUL(10000L, "SUCCESSFUL"),
    DB_ERROR(10001L, "DB_ERROR"),
    SERVER_ERROR(10002L, "SERVER_ERROR"),
    UNKNOWN_ERROR(10003L, "UNKNOWN_ERROR");

    private long code;

    private String msg;

    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
