package com.item.tracker.api.service;

import com.item.tracker.api.model.ItemMessage;

/**
 * Service to handle item messages.
 *
 * @author agherra
 */
public interface ItemMessageService {
    /**
     * Method to process message.
     * @param itemMessage item message
     * @return true if processed or false
     */
    public boolean processMessage(ItemMessage itemMessage);

}
