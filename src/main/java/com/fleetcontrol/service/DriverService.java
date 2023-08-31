package com.fleetcontrol.service;

import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.Vehicle;

import java.util.List;

public interface DriverService {

    public Driver createDriver(Driver driver);

    public List<Driver> getAllDriver();

    public Driver getDriverById(Long id);

    public Driver findByLicenseId(String licenseId);

    public String deleteDriver(Long id);

    public Driver editDriver(Driver driver, Long id);
}
