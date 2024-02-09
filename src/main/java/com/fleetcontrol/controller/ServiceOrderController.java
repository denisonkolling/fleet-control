package com.fleetcontrol.controller;

import com.fleetcontrol.dto.ServiceOrderRequestDTO;
import com.fleetcontrol.service.ServiceOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair-order")
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;

    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @PostMapping
    private ResponseEntity<?> createServiceOrder(@RequestBody ServiceOrderRequestDTO form){
        return new ResponseEntity<>(serviceOrderService.createServiceOrder(form), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllRepairOrders(){
        return new ResponseEntity<>(serviceOrderService.getAllServiceOrder(), HttpStatus.OK);
    }
}

