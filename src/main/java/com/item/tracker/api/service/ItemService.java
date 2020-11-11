package com.item.tracker.api.service;

import com.item.tracker.api.model.Item;

import java.util.List;

/**
 * Service to handle item processing.
 *
 * @author agherra
 */
public interface ItemService {
    /**
     * Method to process an item request.
     * @param item item
     * @return true if processed or false
     */
    public boolean processItemRequest(Item item);

    /**
     * Get list of all items.
     * @return get all the items.
     */
    public List<Item> getItems();

    /**
     * Get a specific item.
     * @return
     */
    public Item getItem(String itemId);

}
