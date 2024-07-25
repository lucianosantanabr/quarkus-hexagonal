package com.tech.application.exception;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class GlobalRestExceptionHandle implements
    ExceptionMapper<BusinessException> {

  @Context
  private UriInfo uriInfo;


  @Override
  public Response toResponse(BusinessException e) {
    return Response
        .status(e.getStatus())
        .entity(ErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .path(uriInfo.getRequestUri().getPath())
            .status(e.getStatus())
            .message(e.getLocalizedMessage())
            .params(e.getParams())
            .code(e.getCode())
            .build())
        .build();
  }
}
