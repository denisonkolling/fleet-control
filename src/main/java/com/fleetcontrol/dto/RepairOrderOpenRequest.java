package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RepairOrderOpenRequest {

    private String plate;

    private LocalDateTime openDate;

    private Long serviceId;

    private Long partId;

}