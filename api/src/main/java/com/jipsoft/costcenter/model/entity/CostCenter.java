package com.jipsoft.costcenter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table
@Entity
public class CostCenter implements Serializable {

    @Id
    @Column(name = "cost_center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private City.State state;

    @Setter
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "costCenter", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Cost> costs;

    public CostCenter(String name, City city) {
        this.name = name;
        this.state = city.getState();
        this.city = city;
        this.costs = new ArrayList<>();
    }
}
