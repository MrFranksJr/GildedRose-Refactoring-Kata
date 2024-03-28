package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class ConjuredItem implements StockItem {
    public static final String NAME = "Conjured";
    private static final int minQuality = 0;
    private final Item item;

    public ConjuredItem(Item item) {
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
        decreaseQuality();
    }

    @Override
    public void updateSellIn() {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItems() {
        decreaseQuality();
    }

    @Override
    public void increaseQuality() {
    }

    @Override
    public void decreaseQuality() {
        for (int i = 0; i < 2; i++) {
            if (item.quality > minQuality) {
                item.quality--;
            }
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
