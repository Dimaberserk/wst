package com.wishmaster.ifmo.ws.jaxws;

import com.sun.jersey.core.util.Base64;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthFilter implements ContainerRequestFilter {
    private final static WebApplicationException unauthorized =
        new WebApplicationException(
            Response.status(Response.Status.UNAUTHORIZED)
                .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"realm\"")
                .entity("Page requires login.").build());

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest)
        throws WebApplicationException {

        // Get the authentication passed in HTTP headers parameters
        String auth = containerRequest.getHeaderValue("authorization");
        if (auth == null)
            throw unauthorized;

        auth = auth.replaceFirst("[Bb]asic ", "");
        String userColonPass = Base64.base64Decode(auth);

        if (!userColonPass.equals("admin:nimda"))
            throw unauthorized;

        return containerRequest;
    }
}