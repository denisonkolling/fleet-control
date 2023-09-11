package com.fleetcontrol.controller;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.service.TyreReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tyre-reading")

public class TyreReadingContrroller {

    @Autowired
    private TyreReadingService tyreReadingService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TyreReadingRequest form){

        return new ResponseEntity<>(tyreReadingService.create(form), HttpStatus.CREATED);
    }
}
