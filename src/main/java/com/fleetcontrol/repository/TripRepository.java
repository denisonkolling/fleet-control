package com.fleetcontrol.repository;

import com.fleetcontrol.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
