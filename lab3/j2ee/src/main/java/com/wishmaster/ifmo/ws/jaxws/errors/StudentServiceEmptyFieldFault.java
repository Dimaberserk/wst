package com.wishmaster.ifmo.ws.jaxws.errors;

public class StudentServiceEmptyFieldFault extends StudentServiceClientFault {
    public StudentServiceEmptyFieldFault(String fieldName) {
        super(fieldName + " cannot be null or empty");
    }
}
