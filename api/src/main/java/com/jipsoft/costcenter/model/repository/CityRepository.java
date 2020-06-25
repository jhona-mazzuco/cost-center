package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameStartingWithIgnoreCase(String name);

}
