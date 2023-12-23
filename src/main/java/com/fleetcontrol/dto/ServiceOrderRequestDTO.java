package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServiceOrderRequestDTO {

    private String plate;

    private LocalDateTime openDate;

    private List<ServiceOrderServiceDTO> services;

    private List<ServiceOrderPartDTO> parts;

}
