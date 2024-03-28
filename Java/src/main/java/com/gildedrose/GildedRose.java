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
            updateQualityAndExpiry(item);
        }
    }

    private static void updateQualityAndExpiry(Item item) {

        updateSellIn(item);

        if (isExpired(item)) {
            updateExpiredItems(item);
        }
    }

    private static void updateExpiredItems(Item item) {
        switch (item.name) {
            case "Aged Brie" -> increaseQuality(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> setQualityTo0(item);
            case "Sulfuras, Hand of Ragnaros" -> {
                return;
            }
            default -> decreaseQuality(item);
        }
    }



    private static void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }



    private static void setQualityTo0(Item item) {
        item.quality = 0;
    }
    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
