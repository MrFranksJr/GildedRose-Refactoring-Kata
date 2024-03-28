package com.gildedrose;

public interface StockItem {
    int minQuality = 0;
    int maxQuality = 50;
    void updateQualityAndSellIn();

    void updateQuality();

    void updateSellIn();

    void updateExpiredItems();

    void increaseQuality();

    void decreaseQuality();

}
