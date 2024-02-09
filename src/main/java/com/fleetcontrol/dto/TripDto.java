package com.fleetcontrol.dto;

import lombok.Data;

@Data
public class TripDto {

    private String vehicle;
    private String origin;
    private String destination;
    private Long distance;

}
