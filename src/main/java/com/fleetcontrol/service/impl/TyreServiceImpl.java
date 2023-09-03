package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.repository.TyreRepository;
import com.fleetcontrol.service.TyreService;
import org.springframework.beans.factory.annotation.Autowired;

public class TyreServiceImpl implements TyreService {

    @Autowired
    private TyreRepository repository;

    @Override
    public Tyre createTyre(Tyre tyre) {
        return repository.save(tyre);
    }
}
