package com.fleetcontrol.controller;

import com.fleetcontrol.model.Product;
import com.fleetcontrol.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

}
