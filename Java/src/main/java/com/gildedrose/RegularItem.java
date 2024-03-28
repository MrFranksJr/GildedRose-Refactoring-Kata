package com.gildedrose;

public class RegularItem implements InventoryItem {
    private final Item item;

    public RegularItem(Item item) {
        this.item = item;
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
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
}
