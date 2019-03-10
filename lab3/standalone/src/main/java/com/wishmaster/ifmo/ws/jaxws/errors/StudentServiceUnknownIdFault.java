package com.wishmaster.ifmo.ws.jaxws.errors;

public class StudentServiceUnknownIdFault extends StudentServiceClientFault {
    public StudentServiceUnknownIdFault(Integer id) {
        super("unknown id " + id);
    }
}
