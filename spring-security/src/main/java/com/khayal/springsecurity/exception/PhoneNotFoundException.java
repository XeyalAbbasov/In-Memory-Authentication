package com.khayal.springsecurity.exception;

public class PhoneNotFoundException extends RuntimeException {
    public PhoneNotFoundException(String message) {

        super(message);
    }
}
