package com.fleetcontrol.dto;

import lombok.Data;

@Data
public class ServiceOrderPartDTO {

    private Long partId;

    private Integer quantity;

    private Double unitPrice;

}
