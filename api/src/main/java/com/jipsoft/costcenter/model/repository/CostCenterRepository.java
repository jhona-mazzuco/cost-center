package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.CostCenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostCenterRepository extends CrudRepository<CostCenter, Long> {
}
