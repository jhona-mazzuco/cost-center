package com.jipsoft.costcenter.model.service;

import com.jipsoft.costcenter.model.entity.City;
import com.jipsoft.costcenter.model.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

}
