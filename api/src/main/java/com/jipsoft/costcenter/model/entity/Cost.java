package com.jipsoft.costcenter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Cost implements Serializable {

    @Id
    @Column(name = "cost_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "cost_center_id")
    private CostCenter costCenter;

    @Setter
    @Digits(integer = 16, fraction = 2)
    private BigDecimal value;

    @Setter
    private String description;

    public Cost(String name, CostCenter costCenter, @Digits(integer = 16, fraction = 2) BigDecimal value, String description) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.costCenter = costCenter;
        this.value = value;
        this.description = description;
    }

}
