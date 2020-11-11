package com.item.tracker.api.dao;

import com.item.tracker.api.model.Item;

import java.util.List;

public interface ItemDao {
    public boolean saveItem(Item item);
    public Item getItem(String id);
    public boolean deleteItem(int id);
    public List<Item> getItems();
}
