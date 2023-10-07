package com.fleetcontrol.service;

import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.Vehicle;

import java.util.List;

public interface DriverService {

    Driver createDriver(Driver driver);

    List<Driver> getAllDriver();

    Driver getDriverById(Long id);

    Driver findByLicenseId(String licenseId);

    String deleteDriver(Long id);

    Driver editDriver(Driver driver, Long id);
}
