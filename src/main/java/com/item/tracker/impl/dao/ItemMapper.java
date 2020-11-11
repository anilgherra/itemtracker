package com.item.tracker.impl.dao;

import com.item.tracker.api.model.Item;
import com.item.tracker.api.model.LatLong;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Item mapper class.
 */
public class ItemMapper implements RowMapper<Item> {


    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item();
        LatLong latLong = new LatLong();
        item.setItemId((rs.getString("item_id")));
        item.setItemManf(rs.getString("item_manf"));
        item.setItemState(rs.getString("item_state"));
        item.setItemType(rs.getString("item_Type"));
        latLong.setLatitude(rs.getString("item_current_location_lat"));
        latLong.setLongitude(rs.getString("item_current_location_long"));
        item.setItemLocation(latLong);
        return item;

    }
}
















