package com.fleetcontrol.repository;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.model.TyreReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TyreReadingRepository extends JpaRepository <TyreReading, Long>{
}
