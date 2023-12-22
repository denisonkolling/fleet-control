package com.fleetcontrol.service;

import com.fleetcontrol.dto.ServiceOrderRequest;
import com.fleetcontrol.model.ServiceOrder;

import java.util.List;

public interface ServiceOrderService {

    ServiceOrder createServiceOrder(ServiceOrderRequest form);

    List<ServiceOrder> getAllServiceOrder();

}
