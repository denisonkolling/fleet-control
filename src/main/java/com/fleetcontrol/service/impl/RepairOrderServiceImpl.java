package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.RepairOrderOpenRequest;
import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.RepairOrder;
import com.fleetcontrol.model.Service;
import com.fleetcontrol.repository.PartRepository;
import com.fleetcontrol.repository.RepairOrderRepository;
import com.fleetcontrol.repository.ServiceRepository;
import com.fleetcontrol.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Autowired
    private RepairOrderRepository repairOrderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PartRepository partRepository;

    @Override
    public RepairOrder createRepairOrder(RepairOrderOpenRequest form) {
        RepairOrder repairOrder = new RepairOrder();
        Service service = serviceRepository.findById(form.getServiceId()).get();
        Part part = partRepository.findById(form.getPartId()).get();

        repairOrder.setService(service);
        repairOrder.setPart(part);
        repairOrder.setOpenDate(form.getOpenDate());
        repairOrder.setPlate(form.getPlate());

        return repairOrderRepository.save(repairOrder);
    }

    @Override
    public List<RepairOrder> getAllRepairOrder() {
        return repairOrderRepository.findAll();
    }


}
