package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.model.TyreReading;
import com.fleetcontrol.repository.TyreReadingRepository;
import com.fleetcontrol.repository.TyreRepository;
import com.fleetcontrol.service.TyreReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TyreReadingServiceImpl implements TyreReadingService {

    @Autowired
    private TyreReadingRepository tyreReadingRepository;

    @Autowired
    private TyreRepository tyreRepository;

    @Override
    public TyreReading createTyreReading(TyreReadingRequest form) {
        TyreReading tyreReading = new TyreReading();
        Tyre tyre = tyreRepository.findById(form.getTyreId()).get();

        tyreReading.setTyre(tyre);
        tyreReading.setInsideTread(form.getInsideTread());
        tyreReading.setMidleTread(form.getMidleTread());
        tyreReading.setOutsideTread(form.getOutsideTread());

        return tyreReadingRepository.save(tyreReading);
    }
}
