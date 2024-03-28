package com.gildedrose;

public interface InventoryItem {

    void updateQualityAndExpiry();
    void updateQuality(Item item);
    void updateSellIn(Item item);
    void updateExpiredItems(Item item);
}
