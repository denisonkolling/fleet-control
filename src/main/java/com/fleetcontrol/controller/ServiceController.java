package com.fleetcontrol.controller;

import com.fleetcontrol.model.Service;
import com.fleetcontrol.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    private ResponseEntity<?> createService(@RequestBody Service service){
        return new ResponseEntity<>(serviceService.createService(service), HttpStatus.CREATED);
    }
}
