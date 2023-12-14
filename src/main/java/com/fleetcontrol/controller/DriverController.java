package com.fleetcontrol.controller;

import com.fleetcontrol.model.Driver;
import com.fleetcontrol.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    public ResponseEntity<?> createDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.createDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping("/driver")
    public ResponseEntity<?> getAllDriver() {
        return new ResponseEntity<>(driverService.getAllDriver(), HttpStatus.OK);
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id){
        return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
    }

    @DeleteMapping("/driver/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id){
        return new ResponseEntity<>(driverService.deleteDriver(id), HttpStatus.OK);
    }

    @PostMapping("/driver/{id}")
    public ResponseEntity<?> editDriver(@RequestBody Driver driver, @PathVariable Long id) {
        return new ResponseEntity<>(driverService.editDriver(driver, id), HttpStatus.CREATED);
    }

    @GetMapping("/driver/license/{licenseId}")
    public ResponseEntity<?> findByLicenseId(@PathVariable String licenseId){
        return new ResponseEntity<>(driverService.findByLicenseId(licenseId), HttpStatus.OK);
    };

    @GetMapping("/driver/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(driverService.findByName(name), HttpStatus.OK);
    }

}
