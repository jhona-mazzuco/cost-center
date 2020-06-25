package com.jipsoft.costcenter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@SequenceGenerator(name = "seq_cost_center", sequenceName = "seq_cost_center", allocationSize = 1)
@Getter
@Table
@Entity
public class CostCenter implements Serializable {

    @Id
    @Column(name = "cost_center_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cost_center")
    private Long id;

    @Setter
    private String name;

    private LocalDateTime createdAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public CostCenter(String name, City city) {
        this.name = name;
        this.city = city;
        this.createdAt = LocalDateTime.now();
    }
}
