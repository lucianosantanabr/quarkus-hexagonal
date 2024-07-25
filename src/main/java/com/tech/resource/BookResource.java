package com.tech.resource;

import com.tech.application.exception.impl.BookNotFoundException;
import com.tech.domain.adapter.BookAdapter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject
  BookAdapter bookAdapter;

  @GET
  public Response getAll() {
    return Response.ok(bookAdapter.getAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response getId(@PathParam("id") Integer id) throws BookNotFoundException {
    return Response.ok(bookAdapter.getId(id)).build();
  }
}
