package com.item.tracker.impl.dao;

import com.item.tracker.api.dao.ItemMessageDao;
import com.item.tracker.api.model.ItemMessage;

import com.item.tracker.api.model.LatLong;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMessageDaoImpl implements ItemMessageDao {
    private JdbcTemplate jdbcTemplate;

    public ItemMessageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveItemMessage(ItemMessage itemMessage){
        LatLong messageLatLong = itemMessage.getItemLocation().get(0);

        int result = jdbcTemplate.update("insert into item_information (item_id, item_type, item_state," +
                "item_manf, item_current_location_lat, item_current_location_long) values (?,?,?,?,?,?)",
                itemMessage.getItemId(), itemMessage.getItemType(), itemMessage.getItemState(),
                itemMessage.getItemManf(), messageLatLong.getLatitude(), messageLatLong.getLongitude());

        return result == 1;
    }

    public ItemMessage getMessage(int id){
        return null;
    }

    public boolean deleteItemMessage(int id){
        return true;
    }
    public List<ItemMessage> getAllMessage() {
        return null;
    }
}
