package com.jipsoft.costcenter.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CostDto {

    private String name;
    private BigDecimal value;
    private String description;
    private Long costCenter;

}
