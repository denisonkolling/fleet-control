package com.fleetcontrol.controller;

import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.service.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TyreController {

    @Autowired
    private TyreService tyreService;

    @PostMapping("/tyre")
    public ResponseEntity<?> createTyre(@RequestBody Tyre tyre){
        return new ResponseEntity<>(tyreService.createTyre(tyre), HttpStatus.CREATED);
    }

    @GetMapping("/tyre")
    public ResponseEntity<?> getAllTyres() {
        return new ResponseEntity<>(tyreService.getAllTyres(), HttpStatus.OK);
    }

    @GetMapping("/tyre/{id}")
    public ResponseEntity<?> getTyreById(@PathVariable Long id){
        return new ResponseEntity<>(tyreService.getTyreById(id), HttpStatus.OK);
    }

    @DeleteMapping("/tyre/{id}")
    public ResponseEntity<?> deleteTyre(@PathVariable Long id){
        return new ResponseEntity<>(tyreService.deleteTyre(id), HttpStatus.OK);
    }

    @PostMapping("/tyre/{id}")
    public ResponseEntity<?> editTyre(@RequestBody Tyre tyre, @PathVariable Long id) {
        return new ResponseEntity<>(tyreService.editTyre(tyre, id), HttpStatus.CREATED);
    }

}
