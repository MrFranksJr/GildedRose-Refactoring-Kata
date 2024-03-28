package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    GildedRose app;

    @Test
    void quality_and_sellin_date_never_change() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 20, 80)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(20, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
}
