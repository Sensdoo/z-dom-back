package com.sens.app.service;

import com.sens.app.model.Entrance;
import com.sens.app.repository.EntranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceService {

    @Autowired
    private EntranceRepository entranceRepository;

    public List<Entrance> getAllByAddressId(Long addressId) {
        return entranceRepository.findByAddressId(addressId);
    }

    public List<Entrance> getAll() {
        return entranceRepository.findAll();
    }

    public Entrance saveEntrance(Entrance entrance) {
        return entranceRepository.save(entrance);
    }

    public void deleteEntrance(Long id) {
        entranceRepository.deleteById(id);
    }

    public boolean existsByEntranceNumberAndAddressId(int entranceNumber, Long addressId) {
        return entranceRepository.existsByEntranceNumberAndAddressId(entranceNumber, addressId);
    }
}
