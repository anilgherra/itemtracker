package com.item.tracker.impl.dao;

import com.item.tracker.api.dao.ItemDao;
import com.item.tracker.api.model.Item;

import com.item.tracker.api.model.LatLong;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ItemDaoImpl implements ItemDao {
    private final JdbcTemplate jdbcTemplate;

    public ItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public boolean saveItem(Item item){
        LatLong latLong = item.getItemLocation();

        int result = jdbcTemplate.update("insert into item_information (item_id, item_type, item_state," +
                "item_manf, item_current_location_lat, item_current_location_long) values (?,?,?,?,?,?)",
                item.getItemId(), item.getItemType(), item.getItemState(),
                item.getItemManf(), latLong.getLatitude(), latLong.getLongitude());

        return result == 1;
    }

    @Override
    public Item getItem(String id) {
        String sqlStatement = "select * from item_information where item_id = ?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{id}, new ItemMapper());
    }

    @Override
    public boolean deleteItem(int id) {
        return false;
    }

    public boolean deleteItemMessage(int id){
        return true;
    }

    public List<Item> getItems() {
        String sqlStatement = "select * from item_information";
        return jdbcTemplate.query(sqlStatement, new ItemMapper());
    }
}
