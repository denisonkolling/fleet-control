package com.fleetcontrol.controller;

import com.fleetcontrol.model.Trip;
import com.fleetcontrol.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripController {

  @Autowired
  private TripService tripService;

  @PostMapping("/trip")
  public ResponseEntity<?> createTrip(@RequestBody Trip trip) {
    return new ResponseEntity<>(tripService.createTrip(trip), HttpStatus.CREATED);
  }

}