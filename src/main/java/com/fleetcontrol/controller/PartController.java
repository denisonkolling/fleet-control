package com.fleetcontrol.controller;

import com.fleetcontrol.model.Part;
import com.fleetcontrol.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/part")
public class PartController {

    @Autowired
    private PartService partService;

    @PostMapping
    private ResponseEntity<?> createPart(@RequestBody Part part){
        return new ResponseEntity<>(partService.createPart(part), HttpStatus.CREATED);
    }
}

