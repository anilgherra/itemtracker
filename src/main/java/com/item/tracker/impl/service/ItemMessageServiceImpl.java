package com.item.tracker.impl.service;

import com.item.tracker.api.dao.ItemMessageDao;
import com.item.tracker.api.model.ItemMessage;
import com.item.tracker.api.service.ItemMessageService;

import org.springframework.stereotype.Service;

/**
 * Implementation of message service.
 *
 * @author agherra
 */
@Service
public class ItemMessageServiceImpl implements ItemMessageService {
    private final ItemMessageDao itemMessageDao;

    public ItemMessageServiceImpl(ItemMessageDao itemMessageDao) {
        this.itemMessageDao = itemMessageDao;
    }
    @Override
    public boolean processMessage(ItemMessage itemMessage) {
        return itemMessageDao.saveItemMessage(itemMessage);
    }
}
