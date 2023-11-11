package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.DrivingHours;
import com.fleetcontrol.repository.DrivingHoursRepository;
import com.fleetcontrol.service.DrivingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingHoursServiceImpl implements DrivingHoursService {

    @Autowired
    DrivingHoursRepository drivingHoursRepository;


    @Override
    public DrivingHours createDrivingHours(DrivingHours drivingHours) {
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
