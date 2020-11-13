package com.item.tracker.api.service;

import com.item.tracker.api.entity.Item;
import com.item.tracker.api.model.ItemDto;

import java.util.List;

/**
 * Service to handle item processing.
 *
 * @author agherra
 */
public interface ItemService {
    /**
     * Method to process an item request.
     * @param itemDto item
     */
     void processItemRequest(ItemDto itemDto);

    /**
     * Get list of all items.
     * @return get all the items.
     */
     List<Item> getItems();

    /**
     * Get a specific item.
     * @return an item object
     */
    Item getItem(long itemId);

}
