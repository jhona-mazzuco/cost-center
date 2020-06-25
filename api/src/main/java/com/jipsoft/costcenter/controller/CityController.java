package com.jipsoft.costcenter.controller;

import com.jipsoft.costcenter.model.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Controller
@Path("/city")
public class CityController extends BaseController {

    @Autowired
    private CityRepository repository;

    @GET
    public Response findAll() {
        return ok(repository.findAll());
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return ok(repository.findById(id).get());
    }

    @GET
    @Path("search")
    public Response search(@QueryParam("search") String name) {
        return ok(repository.findByNameStartingWithIgnoreCase(name));
    }

}
