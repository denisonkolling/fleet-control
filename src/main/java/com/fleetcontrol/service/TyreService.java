package com.fleetcontrol.service;

import com.fleetcontrol.model.Tyre;

import java.util.List;

public interface TyreService {

    Tyre createTyre(Tyre tyre);

    List<Tyre> getAllTyres();

    Tyre getTyreById(Long id);

    String deleteTyre(Long id);

    Tyre editTyre(Tyre tyre, Long id);
}
