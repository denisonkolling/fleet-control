package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.TripDto;
import com.fleetcontrol.model.Trip;
import com.fleetcontrol.repository.TripRepository;
import com.fleetcontrol.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;


    @Override
    public Trip createTrip(TripDto tripDto) {

        var trip = new Trip(
                null,
                tripDto.getVehicle(),
                tripDto.getOrigin(),
                tripDto.getDestination(),
                tripDto.getDistance(),
                null,
                null,
                null
        );

        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}