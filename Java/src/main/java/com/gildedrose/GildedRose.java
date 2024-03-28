package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private final List<Item> itemList;

    public GildedRose(Item[] items) {
        this.items = items;
        itemList = new ArrayList<>();
        itemList.addAll(List.of(items));
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = ItemType.determineItemType(item.name);

            if (itemType != ItemType.AGED_BRIE && itemType != ItemType.BACKSTAGE_PASS) {
                if (item.quality > 0) {
                    if (itemType != ItemType.SULFURAS) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (itemType == ItemType.BACKSTAGE_PASS) {
                        updateBackStagePassesQuality(item);
                    }
                }
            }

            if (itemType != ItemType.SULFURAS) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (itemType != ItemType.AGED_BRIE) {
                    if (itemType != ItemType.BACKSTAGE_PASS) {
                        if (item.quality > 0) {
                            if (itemType != ItemType.SULFURAS) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private static void updateBackStagePassesQuality(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
        }

        if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
        }
    }
}
