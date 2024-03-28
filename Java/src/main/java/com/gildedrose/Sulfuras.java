package com.gildedrose;

public class Sulfuras implements InventoryItem {
    private final Item item;
    public Sulfuras(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndExpiry() {
        updateQuality(item);

        updateSellIn(item);

        if (isExpired(item)) {
            updateExpiredItems(item);
        }
    }

    @Override
    public void updateQuality(Item item) {

    }

    @Override
    public void updateSellIn(Item item) {

    }

    @Override
    public void updateExpiredItems(Item item) {

    }
    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
