package com.gildedrose;

import com.gildedrose.itemtypes.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemsInStock(item);
        }
    }

    private static void updateItemsInStock(Item item) {
        StockItem stockItem;
        switch (item.name) {
            case AgedBrie.NAME -> {
                stockItem = new AgedBrie(item);
            }
            case BackStagePass.NAME -> {
                stockItem = new BackStagePass(item);
            }
            case Sulfuras.NAME -> {
                stockItem = new Sulfuras(item);
            }
            case ConjuredItem.NAME -> {
                stockItem = new ConjuredItem(item);
            }
            default -> {
                stockItem = new RegularItem(item);
            }
        }
        stockItem.updateQualityAndSellIn();
    }

}
