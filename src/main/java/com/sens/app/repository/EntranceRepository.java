package com.sens.app.repository;

import com.sens.app.model.Entrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntranceRepository extends JpaRepository<Entrance, Long> {
    List<Entrance> findByAddressId(Long addressId);
    boolean existsByEntranceNumberAndAddressId(int entranceNumber, long addressId);
}
