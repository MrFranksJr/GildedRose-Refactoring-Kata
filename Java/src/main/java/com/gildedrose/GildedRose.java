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
            if (item.name.equals(AGED_BRIE)) {
                InventoryItem agedBrie = new AgedBrie(item);
                agedBrie.updateQualityAndExpiry();
            } else if (item.name.equals(BACKSTAGE_PASS)) {
                InventoryItem backStagePass = new BackStagePass(item);
                backStagePass.updateQualityAndExpiry();
            } else if (item.name.equals(SULFURAS)) {
                InventoryItem sulfuras = new Sulfuras(item);
                sulfuras.updateQualityAndExpiry();
            } else {
                InventoryItem regularItem = new RegularItem(item);
                regularItem.updateQualityAndExpiry();
            }

            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        updateQuality(item);

        updateSellIn(item);

        if (isExpired(item)) {
            updateExpiredItems(item);
        }
    }

    private static void updateExpiredItems(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            setQualityTo0(item);
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        else {
            decreaseQuality(item);
        }
    }



    private static void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }


    private static void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.sellIn < 11 && item.quality < 50) {
                increaseQuality(item);
            }

            if (item.sellIn < 6 && item.quality < 50) {
                increaseQuality(item);
            }
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        else decreaseQuality(item);
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
