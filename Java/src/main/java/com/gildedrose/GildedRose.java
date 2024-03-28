package com.gildedrose;

import com.gildedrose.itemtypes.AgedBrie;
import com.gildedrose.itemtypes.BackStagePass;
import com.gildedrose.itemtypes.RegularItem;
import com.gildedrose.itemtypes.Sulfuras;

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
                    StockItem agedBrie = new AgedBrie(item);
                    agedBrie.updateQualityAndExpiry();
                }
                case BACKSTAGE_PASS -> {
                    StockItem backStagePass = new BackStagePass(item);
                    backStagePass.updateQualityAndExpiry();
                }
                case SULFURAS -> {
                    StockItem sulfuras = new Sulfuras(item);
                    sulfuras.updateQualityAndExpiry();
                }
                default -> {
                    StockItem regularItem = new RegularItem(item);
                    regularItem.updateQualityAndExpiry();
                }
            }
        }
    }

}
