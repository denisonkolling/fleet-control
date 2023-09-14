package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Item;
import com.fleetcontrol.repository.ItemRepository;
import com.fleetcontrol.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }
}
