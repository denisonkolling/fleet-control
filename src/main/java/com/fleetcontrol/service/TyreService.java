package com.fleetcontrol.service;

import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TyreService {

    Tyre createTyre(Tyre tyre);

    List<Tyre> getAllTyres();

    Tyre getTyreById(Long id);

    String deleteTyre(Long id);

    Tyre editTyre(Tyre tyre, Long id);
}
