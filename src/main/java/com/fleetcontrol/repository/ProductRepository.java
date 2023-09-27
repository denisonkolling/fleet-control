package com.fleetcontrol.repository;

import com.fleetcontrol.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
