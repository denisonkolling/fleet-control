package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Trip;
import com.fleetcontrol.repository.TripRepository;
import com.fleetcontrol.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

  @Autowired
  private TripRepository tripRepository;

  @Override
  public Trip createTrip(Trip trip) {
    return tripRepository.save(trip);
  }


}