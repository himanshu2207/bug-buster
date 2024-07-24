package com.hijack.utils.exception;

public class CustomException extends Exception{

    private String err;

    public CustomException(String msg) {
        this.err = msg;
    }
}
