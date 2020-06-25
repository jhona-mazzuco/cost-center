package com.jipsoft.costcenter.controller;

import com.jipsoft.costcenter.model.entity.Cost;
import com.jipsoft.costcenter.model.repository.CostCenterRepository;
import com.jipsoft.costcenter.model.repository.CostRepository;
import com.jipsoft.costcenter.view.CostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Controller
@Path("/cost")
public class CostController extends BaseController {

    @Autowired
    private CostRepository repository;

    @Autowired
    private CostCenterRepository costCenterRepository;

    @POST
    public Response save(CostDto dto) {
        var costCenter = costCenterRepository.findById(dto.getCostCenter()).orElseThrow();
        var cost = new Cost(dto.getName(), costCenter, dto.getValue(), dto.getDescription());
        return ok( repository.save(cost) );
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, CostDto dto) {
        var entity = repository.findById(id).orElseThrow();
        entity.setDescription(dto.getDescription());

        if (isNotEmpty(dto.getName())) {
            entity.setName(dto.getName());
        }

        if (isNotEmpty(dto.getValue())) {
            entity.setValue(dto.getValue());
        }

        if (isNotEmpty(dto.getDescription())) {
            entity.setDescription(dto.getDescription());
        }

        repository.save(entity);
        return ok();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        repository.deleteById(id);
        return ok();
    }

}
