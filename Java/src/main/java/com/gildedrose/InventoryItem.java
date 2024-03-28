package com.gildedrose;

public interface InventoryItem {

    void updateQualityAndExpiry();

    void updateQuality();

    void updateSellIn();

    void updateExpiredItems();

    void increaseQuality();

    void decreaseQuality();

}
