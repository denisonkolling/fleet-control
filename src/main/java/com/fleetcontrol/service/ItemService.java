package com.fleetcontrol.service;

import com.fleetcontrol.model.Item;

import java.util.function.LongFunction;

public interface ItemService {

    Item createItem(Item item);

    Item findItemById(Long id);

}
