package com.fleetcontrol.service.impl;


import com.fleetcontrol.dto.ServiceOrderPartDTO;
import com.fleetcontrol.dto.ServiceOrderRequestDTO;
import com.fleetcontrol.dto.ServiceOrderServiceDTO;
import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.Service;
import com.fleetcontrol.model.ServiceOrder;
import com.fleetcontrol.model.ServiceOrderPart;
import com.fleetcontrol.repository.*;

import com.fleetcontrol.service.ServiceOrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ServiceOrderServiceRepository serviceOrderServiceRepository;

    @Autowired
    private ServiceOrderPartRepository serviceOrderPartRepository;


    @Override
    public ServiceOrder createServiceOrder(ServiceOrderRequestDTO form) {

        ServiceOrder serviceOrder = new ServiceOrder();

        List<ServiceOrderServiceDTO> serviceDtos = form.getServices();

        List<ServiceOrderPartDTO> partDtos = form.getParts();

        if (serviceDtos != null && !serviceDtos.isEmpty()) {

            List<com.fleetcontrol.model.ServiceOrderService> services = new ArrayList<>();

            for (ServiceOrderServiceDTO serviceDTO : serviceDtos) {

                Service service = serviceRepository.findById(serviceDTO.getServiceId()).orElseThrow(() -> new EntityNotFoundException("Service not found"));

                com.fleetcontrol.model.ServiceOrderService serviceOrderService = new com.fleetcontrol.model.ServiceOrderService();

                serviceOrderService.setService(service);
                serviceOrderService.setQuantity(serviceDTO.getQuantity());
                serviceOrderService.setUnitPrice(serviceDTO.getUnitPrice());

                services.add(serviceOrderService);

            }

            serviceOrder.setServices(services);

        }

        if (partDtos != null && !partDtos.isEmpty()) {

            List<ServiceOrderPart> parts = new ArrayList<>();

            for (ServiceOrderPartDTO partDTO : partDtos) {

                Part part = partRepository.findById(partDTO.getPartId()).orElseThrow(() -> new EntityNotFoundException("Part not found"));

                ServiceOrderPart serviceOrderPart = new ServiceOrderPart();

                serviceOrderPart.setPart(part);
                serviceOrderPart.setQuantity(partDTO.getQuantity());
                serviceOrderPart.setUnitPrice(partDTO.getUnitPrice());

                parts.add(serviceOrderPart);

            }

            serviceOrder.setParts(parts);
        }


        serviceOrder.setOpenDate(form.getOpenDate());
        serviceOrder.setPlate(form.getPlate());

        return serviceOrderRepository.save(serviceOrder);

    }


    @Override
    public List<ServiceOrder> getAllServiceOrder() {
        return serviceOrderRepository.findAll();
    }
}
