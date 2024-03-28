package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE -> {
                    InventoryItem agedBrie = new AgedBrie(item);
                    agedBrie.updateQualityAndExpiry();
                }
                case BACKSTAGE_PASS -> {
                    InventoryItem backStagePass = new BackStagePass(item);
                    backStagePass.updateQualityAndExpiry();
                }
                case SULFURAS -> {
                    InventoryItem sulfuras = new Sulfuras(item);
                    sulfuras.updateQualityAndExpiry();
                }
                default -> {
                    InventoryItem regularItem = new RegularItem(item);
                    regularItem.updateQualityAndExpiry();
                }
            }
        }
    }

}
