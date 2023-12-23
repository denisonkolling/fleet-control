package com.fleetcontrol.service;

import com.fleetcontrol.dto.ServiceOrderRequest;
import com.fleetcontrol.dto.ServiceOrderRequestDTO;
import com.fleetcontrol.model.ServiceOrder;

import java.util.List;

public interface ServiceOrderService {

    ServiceOrder createServiceOrder(ServiceOrderRequestDTO form);

    List<ServiceOrder> getAllServiceOrder();

}
