package com.jipsoft.costcenter.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@SequenceGenerator(name = "seq_cost", sequenceName = "seq_cost", allocationSize = 1)
@Getter
@Entity
@Table
public class Cost implements Serializable {

    @Id
    @Column(name = "cost_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cost")
    private Long id;

    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cost_center_id", nullable = false)
    private CostCenter costCenter;

    @Setter
    private String name;

    private LocalDateTime createdAt;

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
