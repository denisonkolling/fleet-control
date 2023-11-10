package com.fleetcontrol.service;

import com.fleetcontrol.model.DrivingHours;

import java.util.List;

public interface DrivingHoursService {

    DrivingHours createDrivingHours(DrivingHours form);

    List<DrivingHours> getAllDrivingHours();

    List<DrivingHours> getDrivingHoursByDriver(Long id);


}
