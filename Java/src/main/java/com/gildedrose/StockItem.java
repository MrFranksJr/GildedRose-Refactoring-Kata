package com.gildedrose;

public interface StockItem {

    void updateQualityAndExpiry();

    void updateQuality();

    void updateSellIn();

    void updateExpiredItems();

    void increaseQuality();

    void decreaseQuality();

}
