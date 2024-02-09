package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Vehicle;
import com.fleetcontrol.repository.VehicleRepository;
import com.fleetcontrol.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public String deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();

        if (vehicle != null) {
            vehicleRepository.delete(vehicle);
            return "Product deleted successfully";
        }

        return "Something went wrong on server";
    }

    @Override
    public Vehicle editVehicle(Vehicle v, Long id) {

        Vehicle oldVehicle = vehicleRepository.findById(id).get();

        oldVehicle.setDriver(v.getDriver());
        oldVehicle.setMileage(v.getMileage());
        oldVehicle.setModel(v.getModel());
//        oldVehicle.setPlate(v.getPlate());
//        oldVehicle.setYear(v.getYear());
        return vehicleRepository.save(oldVehicle);
    }

    @Override
    public Vehicle getVehicleByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }
}
