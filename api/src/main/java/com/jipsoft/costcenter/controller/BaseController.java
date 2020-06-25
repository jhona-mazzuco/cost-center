package com.jipsoft.costcenter.controller;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Slf4j
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BaseController<T>  {

    public Response ok(Object obj) {
        return Response.ok(obj).build();
    }

    public Response ok() {
        return Response.ok().build();
    }

}
