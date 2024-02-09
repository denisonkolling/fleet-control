package com.fleetcontrol.service;

import com.fleetcontrol.model.Item;

public interface ItemService {

    Item createItem(Item item);

    Item findItemById(Long id);

}
