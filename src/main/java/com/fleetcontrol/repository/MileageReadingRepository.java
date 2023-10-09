package com.fleetcontrol.repository;

import com.fleetcontrol.model.MileageReading;
import com.fleetcontrol.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MileageReadingRepository extends JpaRepository<MileageReading, Long> {
    MileageReading findTopByVehicleOrderByReadingDateDesc(Vehicle vehicle);

    @Query("SELECT mr FROM MileageReading mr WHERE mr.vehicle = :vehicle AND mr.readingDate < :readingDate ORDER BY mr.readingDate DESC")
    List<MileageReading> findByVehicleAndReadingDateBeforeOrderByReadingDateDesc(
            @Param("vehicle") Vehicle vehicle,
            @Param("readingDate") LocalDateTime readingDate
    );

    List<MileageReading> findByVehiclePlate(String vehiclePlate);

    List<MileageReading> findByVehicleId(Long vehicleId);
}
