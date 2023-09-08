package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.repository.TyreRepository;
import com.fleetcontrol.service.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyreServiceImpl implements TyreService {

    @Autowired
    private TyreRepository tyreRepository;

    @Override
    public Tyre createTyre(Tyre tyre) {
        return tyreRepository.save(tyre);
    }

    @Override
    public List<Tyre> getAllTyres() {
        return tyreRepository.findAll();
    }

    @Override
    public Tyre getTyreById(Long id) {
        return tyreRepository.findById(id).get();
    }

    @Override
    public String deleteTyre(Long id) {
        Tyre tyre = tyreRepository.findById(id).get();

        if (tyre != null) {
            tyreRepository.delete(tyre);
            return "Driver deleted successfully";
        }

        return "Something went wrong on server";
    }

    @Override
    public Tyre editTyre(Tyre tyre, Long id) {
        Tyre oldTyre = tyreRepository.findById(id).get();

        oldTyre.setManufacturer(tyre.getManufacturer());
        oldTyre.setSerial(tyre.getSerial());
        oldTyre.setModel(tyre.getModel());
        oldTyre.setSize(tyre.getSize());
        oldTyre.setVehicle(tyre.getVehicle());
//        oldTyre.setInsideTread(tyre.getInsideTread());
//        oldTyre.setMidleTread(tyre.getMidleTread());
//        oldTyre.setOutsideTread(tyre.getOutsideTread());

        return tyreRepository.save(oldTyre);
    }
}
