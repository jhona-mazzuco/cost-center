package com.jipsoft.costcenter.model.repository;

import com.jipsoft.costcenter.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

//    @Override
//    @Query(value = """
//            SELECT * FROM city c WHERE c.city_id = :id LIMIT 1
//            """, nativeQuery = true)
//    public Optional<City> findById(@Param("id") Long id);

//    @Query("SELECT * FROM city WHERE city.state = ${state}")
//    Optional<City> findCityByState(@Param("state") City.State state);

}
