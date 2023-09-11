package com.fleetcontrol.repository;

import com.fleetcontrol.model.MileageReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageReadingRepository extends JpaRepository<MileageReading, Long> {
}
