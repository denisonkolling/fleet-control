package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.TyreReadingRequest;
import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.model.TyreReading;
import com.fleetcontrol.repository.TyreReadingRepository;
import com.fleetcontrol.repository.TyreRepository;
import com.fleetcontrol.service.TyreReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyreReadingServiceImpl implements TyreReadingService {

    private TyreReadingRepository tyreReadingRepository;

    private TyreRepository tyreRepository;

    public TyreReadingServiceImpl(TyreReadingRepository tyreReadingRepository, TyreRepository tyreRepository) {
        this.tyreReadingRepository = tyreReadingRepository;
        this.tyreRepository = tyreRepository;
    }

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

    @Override
    public List<TyreReading> getReadingsByTyreId(Long tyreId) {
        return tyreReadingRepository.findByTyreId(tyreId);
    }
}
