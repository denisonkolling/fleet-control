package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Driver;
import com.fleetcontrol.repository.DriverRepository;
import com.fleetcontrol.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).get();
    }

    @Override
    public Driver findByLicenseId(String licenseId) {
        return driverRepository.findByLicenseId(licenseId);
    }

    @Override
    public String deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id).get();

        if (driver != null) {
            driverRepository.delete(driver);
            return "Driver deleted successfully";
        }

        return "Something went wrong on server";
    }

    @Override
    public Driver editDriver(Driver d, Long id) {

        Driver oldDriver = driverRepository.findById(id).get();

        oldDriver.setFirstName(d.getFirstName());
        oldDriver.setLastName(d.getLastName());
        oldDriver.setLicenseId(d.getLicenseId());
        oldDriver.setExpiryDate(d.getExpiryDate());
        oldDriver.setLicenseClass(d.getLicenseClass());

        return driverRepository.save(oldDriver);
    }
}
