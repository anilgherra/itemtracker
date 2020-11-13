package com.item.tracker.api.model;

import lombok.Data;
/**
 * Using DTO to separate entity/DTO processing.
 * {
 *   "itemId" : "xyz",
 *   "itemType" : "",
 *   "item_manf" : "somethingLLC"
 *   "itemState" : "",
 *   "latitude" : "52.21",
 *   "longitude: "25.21,
 *   "coord_standard" : "ISO-6709"
 * }
 */

@Data
public class ItemDto {
    private long itemId;
    private String itemType;
    private String itemManf;
    private String itemState;
    private float latitude;
    private float longitude;
    private String coord_standard;
}
