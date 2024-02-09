package com.fleetcontrol.service;

import com.fleetcontrol.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicle();

    Vehicle getVehicleById(Long id);

    String deleteVehicle(Long id);

    Vehicle editVehicle(Vehicle vehicle, Long id);

    Vehicle getVehicleByPlate(String plate);

}
