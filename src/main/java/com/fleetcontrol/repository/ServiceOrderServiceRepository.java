package com.fleetcontrol.repository;

import com.fleetcontrol.model.ServiceOrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderServiceRepository extends JpaRepository<ServiceOrderService, Long> {
}
