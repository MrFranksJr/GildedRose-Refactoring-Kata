package com.gildedrose;

public class BackStagePass implements InventoryItem {
    private final Item item;
    public BackStagePass(Item item) {
        this.item = item;
    }

    @Override
    public void updateQualityAndExpiry() {

    }
}
