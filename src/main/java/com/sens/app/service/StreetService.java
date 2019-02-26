package com.sens.app.service;

import com.sens.app.model.Street;
import com.sens.app.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public List<Street> getAll() {
        return streetRepository.findAll();
    }

    public Street getStreet(Long streetId) {
        return streetRepository.getOne(streetId);
    }
}
