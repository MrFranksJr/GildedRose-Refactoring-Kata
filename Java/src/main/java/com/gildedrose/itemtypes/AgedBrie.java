package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class AgedBrie implements StockItem {
    public static final String NAME = "Aged Brie";
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndSellIn() {
        updateQuality();
        updateSellIn();
        if (isExpired()) {
            updateExpiredItems();
        }
    }

    @Override
    public void updateQuality() {
        increaseQuality();
    }

    @Override
    public void updateSellIn() {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItems() {
        increaseQuality();
    }

    @Override
    public void increaseQuality() {
        if (item.quality < maxQuality) {
            item.quality++;
        }
    }

    @Override
    public void decreaseQuality() {
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
