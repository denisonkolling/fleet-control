package com.fleetcontrol.service;

import com.fleetcontrol.dto.RepairOrderOpenRequest;
import com.fleetcontrol.model.Driver;
import com.fleetcontrol.model.RepairOrder;

import java.util.List;

public interface RepairOrderService {

    RepairOrder createRepairOrder(RepairOrderOpenRequest form);

    List<RepairOrder> getAllRepairOrder();
}
