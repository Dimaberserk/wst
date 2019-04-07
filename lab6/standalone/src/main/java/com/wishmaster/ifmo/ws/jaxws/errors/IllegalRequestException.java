package com.wishmaster.ifmo.ws.jaxws.errors;

public class IllegalRequestException extends Exception {
    public IllegalRequestException(String message) {
        super(message);
    }

    public IllegalRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public static IllegalRequestException emptyField(String fieldName) {
        return new IllegalRequestException(fieldName + " cannot be null or empty");
    }

    public static IllegalRequestException unknownId(Integer id) {
        return new IllegalRequestException("unknown id " + id);
    }
}
