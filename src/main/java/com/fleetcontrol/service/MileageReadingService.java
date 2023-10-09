package com.fleetcontrol.service;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.model.MileageReading;
import com.fleetcontrol.model.TyreReading;

import java.util.List;

public interface MileageReadingService {

    MileageReading createMileageReading(MileageReadingRequest form);

    List<MileageReading> getReadingsByVehiclePlate(String vehiclePlate);

    List<MileageReading> getReadingsByVehicleId(Long vehicleId);
}
