package com.fleetcontrol.controller;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.model.TyreReading;
import com.fleetcontrol.service.impl.TyreReadingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tyre-reading")

public class TyreReadingContrroller {

    @Autowired
    private TyreReadingServiceImpl service;

    @PostMapping
    public TyreReading create (@RequestBody TyreReadingRequest form){
        return service.create(form);
    }
}
