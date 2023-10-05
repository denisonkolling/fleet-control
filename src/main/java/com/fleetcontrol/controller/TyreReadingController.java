package com.fleetcontrol.controller;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.service.TyreReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tyre-reading")

public class TyreReadingController {

    @Autowired
    private TyreReadingService tyreReadingService;

    @PostMapping
    public ResponseEntity<?> createTyreReading(@RequestBody TyreReadingRequest form){

        return new ResponseEntity<>(tyreReadingService.createTyreReading(form), HttpStatus.CREATED);
    }

    @GetMapping("{tyreId}")
    public ResponseEntity<?> getReadingsByTyreId(@PathVariable Long tyreId){
        return new ResponseEntity<>(tyreReadingService.getReadingsByTyreId(tyreId), HttpStatus.OK);
    }

}
