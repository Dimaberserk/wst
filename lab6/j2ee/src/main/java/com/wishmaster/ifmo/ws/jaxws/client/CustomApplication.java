package com.wishmaster.ifmo.ws.jaxws.client;

import com.wishmaster.ifmo.ws.jaxws.AuthFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig {
    public CustomApplication() {
        packages("com.wishmaster.ifmo.ws.jaxws");
        register(LoggingFilter.class);

        //Register Auth Filter here
        register(AuthFilter.class);
    }
}