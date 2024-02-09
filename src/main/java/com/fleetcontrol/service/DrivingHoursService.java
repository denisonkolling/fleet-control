package com.fleetcontrol.service;

import com.fleetcontrol.dto.DrivingHoursRequest;
import com.fleetcontrol.model.DrivingHours;

import java.util.List;

public interface DrivingHoursService {

    DrivingHours createDrivingHours(DrivingHoursRequest drivingHoursRequest);

    List<DrivingHours> getAllDrivingHours();

    List<DrivingHours> getDrivingHoursByDriver(Long id);


}
