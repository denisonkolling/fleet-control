package com.fleetcontrol.controller;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.service.MileageReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mileage-reading")

public class MileageReadingController {

    @Autowired
    private MileageReadingService mileageReadingService;

    @PostMapping
    public ResponseEntity<?> createMileageReading(@RequestBody MileageReadingRequest form) {
        return new ResponseEntity<>(mileageReadingService.createMileageReading(form), HttpStatus.CREATED);
    }

    //TODO Implementar Placa Veículo na Consulta da KM -> Consultar pela placa e buscar ID correspondente na tabela de Veículos
    @GetMapping("/vehicle-plate/{vehiclePlate}")
    public ResponseEntity<?> getReadingsByVehicle(@PathVariable String vehiclePlate) {
        return new ResponseEntity<>(mileageReadingService.getReadingsByVehiclePlate(vehiclePlate), HttpStatus.OK);
    }

    @GetMapping("/vehicle-id/{vehicleId}")
    public ResponseEntity<?> getReadingsByVehicleId(@PathVariable Long vehicleId) {
        return new ResponseEntity<>(mileageReadingService.getReadingsByVehicleId(vehicleId), HttpStatus.OK);
    }
}
