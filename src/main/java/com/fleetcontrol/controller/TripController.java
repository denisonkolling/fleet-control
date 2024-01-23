package com.fleetcontrol.controller;

import com.fleetcontrol.dto.TripDto;
import com.fleetcontrol.model.Trip;
import com.fleetcontrol.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

  @Autowired
  private TripService tripService;

  @PostMapping("/trip")
  public ResponseEntity<?> createTrip(@RequestBody TripDto tripDto) {
    return new ResponseEntity<>(tripService.createTrip(tripDto), HttpStatus.CREATED);
  }

  @GetMapping("/trip")
  public ResponseEntity<List<Trip>> getAllTrip() {
    return new ResponseEntity<>(tripService.getAllTrips(), HttpStatus.OK);
  }

}