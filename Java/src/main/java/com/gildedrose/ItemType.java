package com.gildedrose;

public enum ItemType {
    AGED_BRIE,
    SULFURAS,
    BACKSTAGE_PASS,
    NORMAL_ITEM;

    public static ItemType determineItemType(String itemName) {
        return switch (itemName) {
            case "Aged Brie" -> AGED_BRIE;
            case "Backstage passes to a TAFKAL80ETC concert" -> BACKSTAGE_PASS;
            case "Sulfuras, Hand of Ragnaros" ->  SULFURAS;
            default -> NORMAL_ITEM;
        };
    }
}
