package com.fleetcontrol.service;

import com.fleetcontrol.model.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ServiceService {

    Service createService(Service service);

    List<Service> findServiceByName(String serviceName);

}
