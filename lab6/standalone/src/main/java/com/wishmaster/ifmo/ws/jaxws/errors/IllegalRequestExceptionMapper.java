package com.wishmaster.ifmo.ws.jaxws.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalRequestExceptionMapper implements ExceptionMapper<InternalException> {

    @Override
    public Response toResponse(InternalException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
