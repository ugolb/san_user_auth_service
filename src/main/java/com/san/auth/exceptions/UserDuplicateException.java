package com.san.auth.exceptions;

public class UserDuplicateException extends RuntimeException {

    /**
     * Constructs a {@code UserDuplicateException} with no detail message.
     */
    public UserDuplicateException() {
        super();
    }

    /**
     * Constructs a {@code UserDuplicateException} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public UserDuplicateException(String s) {
        super(s);
    }

}
