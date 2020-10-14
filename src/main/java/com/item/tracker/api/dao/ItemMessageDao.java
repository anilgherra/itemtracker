package com.item.tracker.api.dao;

import com.item.tracker.api.model.ItemMessage;

import java.util.List;

public interface ItemMessageDao {
    public boolean saveItemMessage(ItemMessage itemMessage);
    public ItemMessage getMessage(int id);
    public boolean deleteItemMessage(int id);
    public List<ItemMessage> getAllMessage();
}
