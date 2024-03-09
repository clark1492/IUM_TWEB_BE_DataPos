package com.ium.tweb.footballprojpostgres.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }

    public PlayerException() {
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
}
