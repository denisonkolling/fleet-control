package com.fleetcontrol.controller;

import com.fleetcontrol.dto.MileageReadingRequest;
import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.service.MileageReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mileage-reading")

public class MileageReadingController {

    @Autowired
    private MileageReadingService mileageReadingService;

    @PostMapping
    public ResponseEntity<?> createMileageReading(@RequestBody MileageReadingRequest form){

        return new ResponseEntity<>(mileageReadingService.createMileageReading(form), HttpStatus.CREATED);
    }


}
