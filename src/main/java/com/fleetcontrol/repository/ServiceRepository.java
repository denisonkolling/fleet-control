package com.fleetcontrol.repository;

import com.fleetcontrol.model.Service;
import com.fleetcontrol.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s from Service s WHERE s.serviceName ILIKE CONCAT ('%', :serviceName, '%')")
    public List <Service> findByServiceName(String serviceName);
}
