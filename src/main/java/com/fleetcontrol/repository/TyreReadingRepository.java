package com.fleetcontrol.repository;


import com.fleetcontrol.model.TyreReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TyreReadingRepository extends JpaRepository <TyreReading, Long>{
    public List<TyreReading> findByTyreId(Long tyreId);
}
