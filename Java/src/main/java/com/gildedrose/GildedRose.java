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
        if (item.name.equals(AgedBrie.NAME)) {
            stockItem = new AgedBrie(item);
        } else if (item.name.equals(BackStagePass.NAME)) {
            stockItem = new BackStagePass(item);
        } else if (item.name.equals(Sulfuras.NAME)) {
            stockItem = new Sulfuras(item);
        } else if (item.name.startsWith(ConjuredItem.NAME)) {
            stockItem = new ConjuredItem(item);
        } else {
            stockItem = new RegularItem(item);
        }
        stockItem.updateQualityAndSellIn();
    }

}
