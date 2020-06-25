package com.jipsoft.costcenter.controller;

import com.jipsoft.costcenter.model.entity.CostCenter;
import com.jipsoft.costcenter.model.repository.CityRepository;
import com.jipsoft.costcenter.model.repository.CostCenterRepository;
import com.jipsoft.costcenter.model.repository.CostRepository;
import com.jipsoft.costcenter.view.CostCenterDto;
import com.jipsoft.costcenter.view.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Controller
@Path("/cost-center")
public class CostCenterController extends BaseController<CostCenterRepository> {

    @Autowired
    private CostCenterRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CostRepository costRepository;

    @GET
    public Response findAll() {
        return ok( repository.findAll( Sort.by("id")) );
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return ok( repository.findById(id).orElseThrow() );
    }

    @POST
    public Response save(CostCenterDto dto) {
        var city = cityRepository.findById(dto.getCity()).orElseThrow();
        return ok( repository.save(new CostCenter(dto.getName(), city)) );
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CostCenterDto dto) {
        var entity = repository.findById(id).get();

        if (isNotEmpty(dto.getName())) {
            entity.setName(dto.getName());
        }

        if (isNotEmpty(dto.getCity())) {
            var city = cityRepository.findById(dto.getCity()).get();
            entity.setCity(city);
        }

        return ok( repository.save(entity) );
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        repository.deleteById(id);
        return ok();
    }

    @GET
    @Path("{id}/costs")
    public Response getCosts(@PathParam("id") Long id) {
        var costCenter = repository.findById(id).orElseThrow();
        return ok( costRepository.findByCostCenterOrderById(costCenter) );
    }

    @GET
    @Path("dashboard")
    public Response dashboard() {
        var centers = repository.findAll();
        List<DashboardDto> list = centers.stream().map(center -> {
            var costs = costRepository.findByCostCenterOrderById(center);
            return new DashboardDto(
                    center.getName(),
                    costs.stream().map(c -> c.getValue()).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
        }).collect(Collectors.toList());
        return ok(list);
    }
}
