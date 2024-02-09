package com.fleetcontrol.service;

import com.fleetcontrol.dto.TripDto;
import com.fleetcontrol.model.Trip;

import java.util.List;

public interface TripService {

  Trip createTrip(TripDto tripDto);

  List<Trip> getAllTrips();

}