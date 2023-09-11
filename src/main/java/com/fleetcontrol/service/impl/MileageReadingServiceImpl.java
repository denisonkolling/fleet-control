package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.model.MileageReading;
import com.fleetcontrol.model.Vehicle;
import com.fleetcontrol.repository.MileageReadingRepository;
import com.fleetcontrol.repository.VehicleRepository;
import com.fleetcontrol.service.MileageReadingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageReadingServiceImpl implements MileageReadingService {

    @Autowired
    private MileageReadingRepository mileageReadingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public MileageReading createMileageReading(MileageReadingRequest form) {

        Vehicle vehicle = vehicleRepository.findById(form.getVehicleId()).orElseThrow(() -> new EntityNotFoundException("Vehicle not found."));

        List<MileageReading> previousReadings = mileageReadingRepository.findByVehicleAndReadingDateBeforeOrderByReadingDateDesc(vehicle, form.getReadingDate());

        if (!previousReadings.isEmpty()) {
            MileageReading mostRecentReading = previousReadings.get(0);
            if (form.getReadingMiles() <= mostRecentReading.getReadingMiles()) {
                throw new IllegalArgumentException("Miles reading must be higher than last reading before date insert.");
            }
        }

        MileageReading mileageReading = new MileageReading();
        mileageReading.setVehicle(vehicle);
        mileageReading.setReadingDate(form.getReadingDate());
        mileageReading.setReadingMiles(form.getReadingMiles());

        return mileageReadingRepository.save(mileageReading);
    }
}