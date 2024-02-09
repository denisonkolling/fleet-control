package com.fleetcontrol.dto;

import lombok.Data;

@Data
public class ServiceOrderPartRequest {

    private Long partId;

    private Integer quantity;

    private Double unitPrice;

}
