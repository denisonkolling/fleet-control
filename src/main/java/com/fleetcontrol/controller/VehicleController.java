package com.fleetcontrol.controller;

import com.fleetcontrol.model.Vehicle;
import com.fleetcontrol.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/vehicle")
    public ResponseEntity<?> getAllVehicle() {
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    @PostMapping("/vehicle/{id}")
    public ResponseEntity<?> editVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.editVehicle(vehicle, id), HttpStatus.CREATED);
    }

    @GetMapping("/vehicle/plate/{plate}")
    public ResponseEntity<?> getVehicleByPlate(@PathVariable String plate){
        return new ResponseEntity<>(vehicleService.getVehicleByPlate(plate), HttpStatus.OK);
    }

}
