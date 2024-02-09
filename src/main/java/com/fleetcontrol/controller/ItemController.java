package com.fleetcontrol.controller;

import com.fleetcontrol.model.Item;
import com.fleetcontrol.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    private ResponseEntity<?> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }
}
