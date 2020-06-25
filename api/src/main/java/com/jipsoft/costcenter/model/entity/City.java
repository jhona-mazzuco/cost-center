package com.jipsoft.costcenter.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Table
@Entity
public class City implements Serializable {

    @Id
    @Column(name = "city_id")
    private Long id;

    @Setter
    private String name;

}
