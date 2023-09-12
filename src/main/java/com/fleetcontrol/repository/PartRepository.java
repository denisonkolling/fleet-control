package com.fleetcontrol.repository;

import com.fleetcontrol.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
