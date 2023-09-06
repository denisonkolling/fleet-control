package com.fleetcontrol.controller;

import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.service.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TyreController {

    @Autowired
    private TyreService tyreService;

    @PostMapping("/tyre")
    public ResponseEntity<?> createTyre(@RequestBody Tyre tyre){
        return new ResponseEntity<>(tyreService.createTyre(tyre), HttpStatus.CREATED);
    }
}
