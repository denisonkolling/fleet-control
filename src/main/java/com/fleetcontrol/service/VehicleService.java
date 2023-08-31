package com.fleetcontrol.service;

import com.fleetcontrol.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public Vehicle createVehicle(Vehicle vehicle);

    public List<Vehicle> getAllVehicle();

    public Vehicle getVehicleById(Long id);

    public String deleteVehicle(Long id);

    public Vehicle editVehicle(Vehicle vehicle, Long id);


}
