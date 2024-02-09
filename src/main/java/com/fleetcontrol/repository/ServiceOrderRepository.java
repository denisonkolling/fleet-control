package com.fleetcontrol.repository;

import com.fleetcontrol.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
