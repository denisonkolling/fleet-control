package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.DrivingHoursDTO;
import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.DrivingHours;
import com.fleetcontrol.repository.DriverRepository;
import com.fleetcontrol.repository.DrivingHoursRepository;
import com.fleetcontrol.service.DrivingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingHoursServiceImpl implements DrivingHoursService {

    @Autowired
    DrivingHoursRepository drivingHoursRepository;

    @Autowired
    DriverRepository driverRepository;

    @Override
    public DrivingHours createDrivingHours(DrivingHoursDTO drivingHoursDTO) {

        DrivingHours drivingHours = new DrivingHours();

        Driver driver = driverRepository.findById(drivingHoursDTO.getDriverId()).get();

        drivingHours.setDriver(driver);
        drivingHours.setStartDrivingTime(drivingHours.getStartDrivingTime());
        drivingHours.setEndDrivingTime(drivingHoursDTO.getEndDrivingTime());

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
