package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.ServiceOrderRequest;
import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.ServiceOrder;
import com.fleetcontrol.model.Service;
import com.fleetcontrol.repository.PartRepository;
import com.fleetcontrol.repository.ServiceOrderRepository;
import com.fleetcontrol.repository.ServiceRepository;
import com.fleetcontrol.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PartRepository partRepository;

    @Override
    public ServiceOrder createServiceOrder(ServiceOrderRequest form) {
        ServiceOrder repairOrder = new ServiceOrder();
        Service service = serviceRepository.findById(form.getServiceId()).get();
        Part part = partRepository.findById(form.getPartId()).get();

        repairOrder.setService(service);
        repairOrder.setPart(part);
        repairOrder.setOpenDate(form.getOpenDate());
        repairOrder.setPlate(form.getPlate());

        return serviceOrderRepository.save(repairOrder);
    }

    @Override
    public List<ServiceOrder> getAllServiceOrder() {
        return serviceOrderRepository.findAll();
    }


}
