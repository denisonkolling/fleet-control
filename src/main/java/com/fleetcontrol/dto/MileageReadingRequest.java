package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MileageReadingRequest {

    private Long vehicleId;

    private LocalDateTime readingDate;

    private int readingMiles;

}
