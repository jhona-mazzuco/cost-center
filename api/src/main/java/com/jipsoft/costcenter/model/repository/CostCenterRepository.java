package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {

}
