package com.fleetcontrol.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceOrderResponse {

    private Long id;

    private String plate;

    private LocalDateTime openDate;

    private List<ServiceOrderServiceDTO> services;

    private List<ServiceOrderPartDTO> parts;

}
