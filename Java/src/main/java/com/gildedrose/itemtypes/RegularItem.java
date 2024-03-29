package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class RegularItem implements StockItem {
    private final Item item;
    private final int minQuality = 0;
    private final int maxQuality = 50;

    public RegularItem(Item item) {
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

    public void increaseQuality() {
        if (item.quality < maxQuality) {
            item.quality++;
        }
    }

    public void decreaseQuality() {
        if (item.quality > minQuality) {
            item.quality--;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
