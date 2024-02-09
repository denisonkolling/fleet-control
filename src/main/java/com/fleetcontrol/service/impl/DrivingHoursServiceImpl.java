package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.DrivingHoursRequest;
import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.DrivingHours;
import com.fleetcontrol.repository.DriverRepository;
import com.fleetcontrol.repository.DrivingHoursRepository;
import com.fleetcontrol.service.DrivingHoursService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DrivingHoursServiceImpl implements DrivingHoursService {


    DrivingHoursRepository drivingHoursRepository;
    DriverRepository driverRepository;

    public DrivingHoursServiceImpl(DrivingHoursRepository drivingHoursRepository, DriverRepository driverRepository) {
        this.drivingHoursRepository = drivingHoursRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    public DrivingHours createDrivingHours(DrivingHoursRequest drivingHoursRequest) {

        DrivingHours drivingHours = new DrivingHours();

        Driver driver = driverRepository.findById(drivingHoursRequest.getDriverId()).orElseThrow(() -> new NoSuchElementException("Empty driver."));

        drivingHours.setDriver(driver);
        drivingHours.setStartDrivingTime(drivingHoursRequest.getStartDrivingTime());
        drivingHours.setEndDrivingTime(drivingHoursRequest.getEndDrivingTime());

        return drivingHoursRepository.save(drivingHours);

    }

    @Override
    public List<DrivingHours> getAllDrivingHours() {
        return drivingHoursRepository.findAll();
    }

    @Override
    public List<DrivingHours> getDrivingHoursByDriver(Long id) {
        return null;
    }
}
