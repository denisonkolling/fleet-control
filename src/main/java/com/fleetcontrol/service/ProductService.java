package com.fleetcontrol.service;

import com.fleetcontrol.dto.ProductDto;
import com.fleetcontrol.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

}
