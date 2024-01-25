package com.fleetcontrol.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class DrivingHoursDTO {

    private Long driverId;

    private LocalDateTime startDrivingTime;

    private LocalDateTime endDrivingTime;

}
