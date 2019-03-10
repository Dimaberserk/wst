package com.wishmaster.ifmo.ws.jaxws.errors;

public class StudentServiceInternalFault {
    private static final String DEFAULT_MESSAGE = "Internal error";
    private String message;

    public StudentServiceInternalFault(String message) {
        this.message = message;
    }

    public StudentServiceInternalFault() {
        this(DEFAULT_MESSAGE);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
