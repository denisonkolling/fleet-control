package com.fleetcontrol.service;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.model.MileageReading;

public interface MileageReadingService {

    MileageReading createMileageReading(MileageReadingRequest form);

}
