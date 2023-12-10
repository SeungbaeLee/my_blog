package com.example.demo.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    EMAIL_EXISTS(409,"회원가입이 완료된 이메일입니다.");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
