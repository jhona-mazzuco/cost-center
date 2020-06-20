package com.jipsoft.costcenter.controller;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Controller
@Path("/cost")
public class CostController extends BaseController {

    @GET
    public Response hello() {
        return Response.ok("world").build();
    }
}
