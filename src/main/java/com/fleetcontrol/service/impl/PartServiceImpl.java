package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Part;
import com.fleetcontrol.repository.PartRepository;
import com.fleetcontrol.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;


    @Override
    public Part createPart(Part part) {
        return partRepository.save(part);
    }
}
