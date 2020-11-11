package com.item.tracker.impl.service;

import com.item.tracker.api.dao.ItemDao;
import com.item.tracker.api.model.Item;
import com.item.tracker.api.service.ItemService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of item service.
 *
 * @author agherra
 */
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;


    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public boolean processItemRequest(Item item) {
        return itemDao.saveItem(item);
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public Item getItem(String itemId) {
        return itemDao.getItem(itemId);
    }
}
