package com.fleetcontrol.controller;

import com.fleetcontrol.dto.DrivingHoursRequest;
import com.fleetcontrol.service.DrivingHoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driving-hours")
public class DrivingHoursController {

    private final DrivingHoursService drivingHoursService;

    public DrivingHoursController(DrivingHoursService drivingHoursService) {
        this.drivingHoursService = drivingHoursService;
    }

    @PostMapping
    public ResponseEntity<?> createDrivingHours(@RequestBody DrivingHoursRequest drivingHours) {
        return new ResponseEntity<>(drivingHoursService.createDrivingHours(drivingHours), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDrivingHours() {
        return new ResponseEntity<>(drivingHoursService.getAllDrivingHours(), HttpStatus.OK);
    }
}
