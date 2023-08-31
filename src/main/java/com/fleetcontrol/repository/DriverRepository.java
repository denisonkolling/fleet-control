package com.fleetcontrol.repository;

import com.fleetcontrol.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    public Driver findByLicenseId(String licenseId);

}
