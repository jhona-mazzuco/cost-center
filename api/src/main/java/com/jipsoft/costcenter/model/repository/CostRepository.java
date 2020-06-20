package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.Cost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends CrudRepository<Cost, Long> {
}
