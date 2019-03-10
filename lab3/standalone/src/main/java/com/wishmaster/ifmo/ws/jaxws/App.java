package com.wishmaster.ifmo.ws.jaxws;

import javax.xml.ws.Endpoint;
public class App {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://0.0.0.0:8081/jaxws/StudentService";
        Endpoint.publish(url, new StudentWebService());
    }
}