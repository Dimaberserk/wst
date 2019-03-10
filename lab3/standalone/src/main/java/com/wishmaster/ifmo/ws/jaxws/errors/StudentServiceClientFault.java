package com.wishmaster.ifmo.ws.jaxws.errors;

public class StudentServiceClientFault {
    private String message;

    public StudentServiceClientFault(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
