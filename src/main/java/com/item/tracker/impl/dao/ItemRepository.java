package com.item.tracker.impl.dao;

import com.item.tracker.api.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAll();

    Item findByItemId(long itemId);

    void deleteAllByItemId(String itemId);
}
