package com.fleetcontrol.dto;

import lombok.Data;

@Data
public class ServiceOrderServiceResponse {

    private Long serviceId;

    private String name;

    private Integer quantity;

    private Double unitPrice;


}
