package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class AgedBrie implements StockItem {
    public static final String NAME = "Aged Brie";
    private final Item item;
    private final int maxQuality = 50;

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

    public void increaseQuality() {
        if (item.quality < maxQuality) {
            item.quality++;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
