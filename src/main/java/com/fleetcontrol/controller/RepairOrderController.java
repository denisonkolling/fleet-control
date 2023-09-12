package com.fleetcontrol.controller;

import com.fleetcontrol.dto.RepairOrderOpenRequest;
import com.fleetcontrol.model.RepairOrder;
import com.fleetcontrol.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair-order")
public class RepairOrderController {

    @Autowired
    private RepairOrderService repairOrderService;

    @PostMapping
    private ResponseEntity<?> createRepairOrder(@RequestBody RepairOrderOpenRequest form){
        return new ResponseEntity<>(repairOrderService.createRepairOrder(form), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllRepairOrders(){
        return new ResponseEntity<>(repairOrderService.getAllRepairOrder(), HttpStatus.OK);
    }
}

