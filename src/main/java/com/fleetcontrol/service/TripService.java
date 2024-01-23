package com.fleetcontrol.service;

import com.fleetcontrol.dto.TripDto;
import com.fleetcontrol.model.Trip;
import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.model.Vehicle;

import java.util.List;

public interface TripService {

  Trip createTrip(TripDto tripDto);

  List<Trip> getAllTrips();

}