package com.fleetcontrol.service;

import com.fleetcontrol.model.Tyre;
import com.fleetcontrol.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TyreService {

    public Tyre createTyre(Tyre tyre);

    public List<Tyre> getAllTyres();

    public Tyre getTyreById(Long id);

    public String deleteTyre(Long id);

    public Tyre editTyre(Tyre tyre, Long id);
}
