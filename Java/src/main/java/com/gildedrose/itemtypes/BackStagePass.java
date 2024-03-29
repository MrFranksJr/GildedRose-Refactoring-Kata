package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class BackStagePass implements StockItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    private final Item item;
    private final int minQuality = 0;
    private final int maxQuality = 50;

    public BackStagePass(Item item) {
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

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    public void updateSellIn() {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItems() {
        setQualityToMinimum();
    }

    private void setQualityToMinimum() {
        item.quality = minQuality;
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
