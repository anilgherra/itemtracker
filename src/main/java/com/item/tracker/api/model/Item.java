package com.item.tracker.api.model;

/**
 *
 * {
 *   "itemId" : "xyz",
 *   "itemType" : "",
 *   "item_manf" : "somethingLLC"
 *   "itemState" : "",
 *   "itemLocation" : [{
 *     "lat" : "53.43",
 *     "long" : "42.34"}],
 *   "coord_standard" : "ISO-6709"
 * }
 */

public class Item {
    private String itemId;
    private String itemType;
    private String itemManf;
    private String itemState;
    private LatLong itemLocation;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemState() {
        return itemState;
    }

    public void setItemState(String itemState) {
        this.itemState = itemState;
    }

    public LatLong getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(LatLong itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemManf() {
        return itemManf;
    }

    public void setItemManf(String itemManf) {
        this.itemManf = itemManf;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemManf='" + itemManf + '\'' +
                ", itemState='" + itemState + '\'' +
                ", itemLocation=" + itemLocation +
                '}';
    }
}
