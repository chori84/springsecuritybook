package com.chori.springsecuritybook.user;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String message, Exception e) {
        super(message, e);
    }
}
