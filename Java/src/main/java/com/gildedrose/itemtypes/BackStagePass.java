package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.StockItem;

public class BackStagePass implements StockItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    private final Item item;
    private static final int maxQuality = 50;
    private static final int minQuality = 0;

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

        if (item.sellIn < 11 && item.quality < maxQuality) {
            increaseQuality();
        }

        if (item.sellIn < 6 && item.quality < maxQuality) {
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
