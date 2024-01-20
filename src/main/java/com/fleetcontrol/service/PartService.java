package com.fleetcontrol.service;

import com.fleetcontrol.model.Part;

import java.util.List;

public interface PartService {

    Part createPart(Part part);

    List <Part> findByPartName(String name);
}
