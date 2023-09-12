package com.fleetcontrol.repository;

import com.fleetcontrol.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
