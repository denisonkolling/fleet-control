package com.fleetcontrol.repository;

import com.fleetcontrol.model.DrivingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrivingHoursRepository extends JpaRepository<DrivingHours, Long> {
}
