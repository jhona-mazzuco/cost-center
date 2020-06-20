package com.jipsoft.costcenter.controller;

import com.jipsoft.costcenter.model.entity.Cost;
import com.jipsoft.costcenter.model.entity.CostCenter;
import com.jipsoft.costcenter.model.repository.CityRepository;
import com.jipsoft.costcenter.model.repository.CostCenterRepository;
import com.jipsoft.costcenter.view.CostCenterDto;
import com.jipsoft.costcenter.view.CostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Controller
@Path("/cost-center")
public class CostCenterController extends BaseController {

    @Autowired
    private CostCenterRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @GET
    public Response findAll() {
        return Response.ok( repository.findAll() ).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok( repository.findById(id).orElseThrow() ).build();
    }

    @POST
    public Response save(CostCenterDto dto) {
        var city = cityRepository.findById(dto.getCity());
        var entity = new CostCenter();
        return Response.ok( repository.save(entity) ).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CostCenterDto dto) {
        var city = cityRepository.findById(dto.getCity()).get();
        var entity = repository.findById(id).get();
        entity.setName(dto.getName());
        entity.setState(dto.getState());
        entity.setCity(city);
        return Response.ok( repository.save(entity) ).build();
    }

    @POST
    @Path("/{id}/cost")
    public Response newCost(@PathParam("id") Long id, CostDto dto) {
        var entity = repository.findById(id).orElseThrow();

        var cost = new Cost(dto.getName(), dto.getCostCenter(), dto.getValue(), dto.getDescription());

        entity.getCosts().add(cost);

        return Response.ok( repository.save(entity) ).build();
    }
}
