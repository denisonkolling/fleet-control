package com.fleetcontrol.repository;

import com.fleetcontrol.model.ServiceOrderPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderPartRepository extends JpaRepository<ServiceOrderPart, Long> {
}
