package com.wishmaster.ifmo.ws.jaxws.errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.wishmaster.ifmo.ws.jaxws.errors.StudentServiceClientFault")
public class IllegalRequestException extends Exception {
    private final StudentServiceClientFault fault;

    public IllegalRequestException(String message, StudentServiceClientFault fault) {
        super(message);
        this.fault = fault;
    }

    public IllegalRequestException(String message, StudentServiceClientFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public IllegalRequestException(String message, String faultMessage, Throwable cause) {
        super(message, cause);
        this.fault = new StudentServiceClientFault(faultMessage);
    }

    public IllegalRequestException(String message, String faultMessage) {
        super(message);
        this.fault = new StudentServiceClientFault(faultMessage);
    }

    public StudentServiceClientFault getFaultInfo() {
        return fault;
    }
}
