package com.fleetcontrol.controller;

import com.fleetcontrol.dto.ServiceOrderRequest;
import com.fleetcontrol.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    private ResponseEntity<?> createServiceOrder(@RequestBody ServiceOrderRequest form){
        return new ResponseEntity<>(serviceOrderService.createServiceOrder(form), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllRepairOrders(){
        return new ResponseEntity<>(serviceOrderService.getAllServiceOrder(), HttpStatus.OK);
    }
}

