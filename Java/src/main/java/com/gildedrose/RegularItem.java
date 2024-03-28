package com.gildedrose;

public class RegularItem implements InventoryItem {
    private final Item item;
    public RegularItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndExpiry() {

    }
}
