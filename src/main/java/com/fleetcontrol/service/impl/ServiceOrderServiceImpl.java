package com.fleetcontrol.service.impl;


import com.fleetcontrol.dto.*;
import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.Service;
import com.fleetcontrol.model.ServiceOrder;
import com.fleetcontrol.model.ServiceOrderPart;
import com.fleetcontrol.repository.*;

import com.fleetcontrol.service.ServiceOrderService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    private ServiceOrderRepository serviceOrderRepository;

    private ServiceRepository serviceRepository;

    private PartRepository partRepository;

    private ModelMapper modelMapper;

    public ServiceOrderServiceImpl(ServiceOrderRepository serviceOrderRepository, ServiceRepository serviceRepository, PartRepository partRepository, ModelMapper modelMapper) {
        this.serviceOrderRepository = serviceOrderRepository;
        this.serviceRepository = serviceRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ServiceOrder createServiceOrder(ServiceOrderRequestDTO form) {

        ServiceOrder serviceOrder = new ServiceOrder();

        List<ServiceOrderServiceDTO> serviceDtos = form.getServices();

        List<ServiceOrderPartRequest> partDtos = form.getParts();

        if (serviceDtos != null && !serviceDtos.isEmpty()) {

            List<com.fleetcontrol.model.ServiceOrderService> services = new ArrayList<>();

            for (ServiceOrderServiceDTO serviceDTO : serviceDtos) {

                Service service = serviceRepository.findById(serviceDTO.getServiceId()).orElseThrow(() -> new EntityNotFoundException("Service not found"));

                com.fleetcontrol.model.ServiceOrderService serviceOrderService = new com.fleetcontrol.model.ServiceOrderService();

                serviceOrderService.setServiceOrder(serviceOrder);
                serviceOrderService.setService(service);
                serviceOrderService.setQuantity(serviceDTO.getQuantity());
                serviceOrderService.setUnitPrice(serviceDTO.getUnitPrice());

                services.add(serviceOrderService);

            }

            serviceOrder.setServices(services);

        }

        if (partDtos != null && !partDtos.isEmpty()) {

            List<ServiceOrderPart> parts = new ArrayList<>();

            for (ServiceOrderPartRequest partDTO : partDtos) {

                Part part = partRepository.findById(partDTO.getPartId()).orElseThrow(() -> new EntityNotFoundException("Part not found"));

                ServiceOrderPart serviceOrderPart = new ServiceOrderPart();

                serviceOrderPart.setServiceOrder(serviceOrder);
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
    public List<ServiceOrderResponse> getAllServiceOrder() {

        List<ServiceOrder> orders = serviceOrderRepository.findAll();

        return orders.stream()
                .map(this::mapToServiceOrderResponse)
                .collect(Collectors.toList());
    }

    private ServiceOrderResponse mapToServiceOrderResponse(ServiceOrder serviceOrder) {
        ServiceOrderResponse serviceOrderResponse = modelMapper.map(serviceOrder, ServiceOrderResponse.class);

        List<ServiceOrderServiceResponse> servicesResponse = serviceOrder.getServices().stream()
                .map(serviceOrderService -> {
                    ServiceOrderServiceResponse serviceOrderServiceResponse = modelMapper.map(serviceOrderService, ServiceOrderServiceResponse.class);
                    serviceOrderServiceResponse.setName(serviceOrderService.getService().getServiceName());
                    return serviceOrderServiceResponse;
                })
                .collect(Collectors.toList());

        List<ServiceOrderPartResponse> partsResponse = serviceOrder.getParts().stream()
                .map(serviceOrderPart -> {
                    ServiceOrderPartResponse serviceOrderPartResponse = modelMapper.map(serviceOrderPart, ServiceOrderPartResponse.class);
                    serviceOrderPartResponse.setName(serviceOrderPart.getPart().getPartName());
                    return serviceOrderPartResponse;
                })
                .collect(Collectors.toList());

        serviceOrderResponse.setServices(servicesResponse);
        serviceOrderResponse.setParts(partsResponse);

        return serviceOrderResponse;
    }
}

