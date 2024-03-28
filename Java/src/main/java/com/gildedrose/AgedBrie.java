package com.gildedrose;

public class AgedBrie implements InventoryItem {
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndExpiry() {
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
        if (item.quality < 50) {
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
