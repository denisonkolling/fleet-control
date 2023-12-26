package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServiceOrderResponse {

    private Long id;

    private String plate;

    private LocalDateTime openDate;

    private List<ServiceOrderServiceResponse> services;

    private List<ServiceOrderPartResponse> parts;

}
