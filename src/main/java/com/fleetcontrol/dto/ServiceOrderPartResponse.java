package com.fleetcontrol.dto;

import lombok.Data;

@Data
public class ServiceOrderPartResponse {

    private Long partId;

    private String name;

    private Integer quantity;

    private Double unitPrice;

}
