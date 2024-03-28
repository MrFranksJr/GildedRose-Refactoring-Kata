package com.gildedrose;

public class AgedBrie implements InventoryItem {
    private final Item item;
    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndExpiry() {

    }
}
