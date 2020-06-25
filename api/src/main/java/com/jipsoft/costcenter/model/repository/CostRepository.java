package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.Cost;
import com.jipsoft.costcenter.model.entity.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    List<Cost> findByCostCenter(CostCenter costCenter);

}
