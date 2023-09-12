package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Service;
import com.fleetcontrol.repository.ServiceRepository;
import com.fleetcontrol.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }
}
