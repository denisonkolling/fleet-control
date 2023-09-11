package com.fleetcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseRequest {
    public Long tripId;

    public String description;

    public String category;

    public Double value;

    public Date expenseDate;
}
