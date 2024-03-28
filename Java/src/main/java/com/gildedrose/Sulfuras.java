package com.gildedrose;

public class Sulfuras implements InventoryItem {
    private final Item item;
    public Sulfuras(Item item) {
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
    public void updateQuality() { }

    @Override
    public void updateSellIn() {

    }

    @Override
    public void updateExpiredItems() {

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
