package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Service;
import com.fleetcontrol.repository.ServiceRepository;
import com.fleetcontrol.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List <Service> findServiceByName(String serviceName) {
        return serviceRepository.findByServiceName(serviceName);
    }
}
