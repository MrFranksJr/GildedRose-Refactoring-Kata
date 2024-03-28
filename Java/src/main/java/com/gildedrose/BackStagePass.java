package com.gildedrose;

public class BackStagePass implements InventoryItem {
    private final Item item;

    public BackStagePass(Item item) {
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

        if (item.sellIn < 11 && item.quality < 50) {
            increaseQuality();
        }

        if (item.sellIn < 6 && item.quality < 50) {
            increaseQuality();
        }
    }

    @Override
    public void updateSellIn() {
        item.sellIn--;
    }

    @Override
    public void updateExpiredItems() {
        setQualityTo0();
    }

    private void setQualityTo0() {
        item.quality = 0;
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
