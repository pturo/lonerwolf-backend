package com.pturo.lonerwolf.exceptions;

public class LonerWolfException extends RuntimeException {
    public LonerWolfException(String exception) {
        super(exception);
    }

    public LonerWolfException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
}
