package com.fleetcontrol.repository;

import com.fleetcontrol.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
