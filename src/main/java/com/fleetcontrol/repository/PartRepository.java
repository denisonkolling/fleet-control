package com.fleetcontrol.repository;

import com.fleetcontrol.model.Part;
import com.fleetcontrol.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    @Query("SELECT p from Part p WHERE p.partName ILIKE CONCAT ('%', :partName, '%')")
    public List<Part> findByPartName(String partName);

}
