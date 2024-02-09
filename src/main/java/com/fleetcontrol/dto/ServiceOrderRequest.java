package com.fleetcontrol.dto;

import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServiceOrderRequest {

    private String plate;

    private LocalDateTime openDate;

    private List<Service> services;

    private List<Part> parts;

}