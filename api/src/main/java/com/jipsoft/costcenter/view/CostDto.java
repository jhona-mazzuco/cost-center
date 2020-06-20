package com.jipsoft.costcenter.view;

import com.jipsoft.costcenter.model.entity.CostCenter;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CostDto {

    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private CostCenter costCenter;
    private BigDecimal value;
    private String description;

}
