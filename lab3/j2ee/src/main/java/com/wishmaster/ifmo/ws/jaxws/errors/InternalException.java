package com.wishmaster.ifmo.ws.jaxws.errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.wishmaster.ifmo.ws.jaxws.errors.StudentServiceInternalFault")
public class InternalException extends Exception {
    private final StudentServiceInternalFault fault;

    public InternalException(String message, StudentServiceInternalFault fault) {
        super(message);
        this.fault = fault;
    }

    public InternalException(String message, StudentServiceInternalFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public InternalException(String message, Throwable cause) {
        super(message, cause);
        this.fault = new StudentServiceInternalFault();
    }

    public StudentServiceInternalFault getFaultInfo() {
        return fault;
    }
}
