package com.fleetcontrol.service;

import com.fleetcontrol.dto.DrivingHoursDTO;
import com.fleetcontrol.model.DrivingHours;

import java.util.List;

public interface DrivingHoursService {

    DrivingHours createDrivingHours(DrivingHoursDTO drivingHoursDTO);

    List<DrivingHours> getAllDrivingHours();

    List<DrivingHours> getDrivingHoursByDriver(Long id);


}
