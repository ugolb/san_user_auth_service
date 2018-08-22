package com.san.auth.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    /**
     * Constructs a {@code UserAlreadyExistException} with no detail message.
     */
    public UserAlreadyExistException() {
        super();
    }

    /**
     * Constructs a {@code UserAlreadyExistException} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public UserAlreadyExistException(String s) {
        super(s);
    }
}
