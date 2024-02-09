package com.fleetcontrol.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DrivingHoursRequest {

    private Long driverId;

    private LocalDateTime startDrivingTime;

    private LocalDateTime endDrivingTime;

}
