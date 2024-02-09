package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TyreReadingRequest {

    private Long tyreId;

    private Double insideTread;

    private Double midleTread;

    private Double outsideTread;
}
