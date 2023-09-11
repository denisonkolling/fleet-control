package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.model.MileageReading;
import com.fleetcontrol.model.Vehicle;
import com.fleetcontrol.repository.MileageReadingRepository;
import com.fleetcontrol.repository.VehicleRepository;
import com.fleetcontrol.service.MileageReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MileageReadingServiceImpl implements MileageReadingService {

    @Autowired
    private MileageReadingRepository mileageReadingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public MileageReading createMileageReading(MileageReadingRequest form) {
        MileageReading mileageReading = new MileageReading();
        Vehicle vehicle = vehicleRepository.findById(form.getVehicleId()).get();

        mileageReading.setVehicle(vehicle);
        mileageReading.setReadingDate(form.getReadingDate());
        mileageReading.setReadingMiles(form.getReadingMiles());

        return mileageReadingRepository.save(mileageReading);
    }
}
