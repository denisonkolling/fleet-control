package com.fleetcontrol.repository;

import com.fleetcontrol.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    public Vehicle findByPlate(String plate);

}
