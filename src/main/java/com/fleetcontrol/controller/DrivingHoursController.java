package com.fleetcontrol.controller;

import com.fleetcontrol.model.DrivingHours;
import com.fleetcontrol.service.DrivingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driving-hours")
public class DrivingHoursController {

    @Autowired
    DrivingHoursService drivingHoursService;

    @PostMapping
    public ResponseEntity<?> createDrivingHours(@RequestBody DrivingHours drivingHours){
        return new ResponseEntity<>(drivingHoursService.createDrivingHours(drivingHours), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDrivingHours() {
        return new ResponseEntity<>(drivingHoursService.getAllDrivingHours(), HttpStatus.OK);
    }
}
