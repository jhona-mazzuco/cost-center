package com.jipsoft.costcenter.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DashboardDto {

    private String name;
    private BigDecimal value;

}
