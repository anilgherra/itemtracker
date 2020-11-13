package com.item.tracker.impl.service;

import com.item.tracker.api.entity.Item;
import com.item.tracker.api.model.ItemDto;
import com.item.tracker.api.service.ItemService;

import com.item.tracker.impl.dao.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of item service.
 *
 * @author agherra
 */
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void processItemRequest(ItemDto itemDto) {
        log.info("Processing item request ");
        try {
            Item itemToSave = new Item();
            itemToSave.setItemId(itemDto.getItemId());
            itemToSave.setItemManf(itemDto.getItemManf());
            itemToSave.setItemState(itemDto.getItemState());
            itemToSave.setItemType(itemDto.getItemType());
            itemToSave.setLatitude(itemDto.getLatitude());
            itemToSave.setLongitude(itemDto.getLongitude());
            itemRepository.save(itemToSave);
        } catch (DataAccessException e) {
            log.error("Error while inserting a new record with id: {}", itemDto.getItemId(), e);
            throw e;
        }
    }

    public List<Item> getItems() {
        try {
            return itemRepository.findAll();
        } catch (DataAccessException e) {
            log.error("Error while trying to find all item records: ", e);
        }
        return null;
    }

    public Item getItem(long itemId) {
        try{
            return itemRepository.findByItemId(itemId);
        } catch(DataAccessException e) {
            log.error("Error while attempting to get an item record with id: {}", itemId, e);
        }
        return null;
    }
}
