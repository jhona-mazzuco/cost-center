package com.jipsoft.costcenter.view;

import com.jipsoft.costcenter.model.entity.City;
import com.jipsoft.costcenter.model.entity.Cost;
import lombok.Data;

import java.util.List;

@Data
public class CostCenterDto {

    private Long id;
    private String name;
    private City.State state;
    private Long city;
    private List<Cost> costs;

}
