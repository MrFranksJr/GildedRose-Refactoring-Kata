package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    GildedRose app;

    @Test
    void quality_increased_when_item_gets_older() {
        final Item[] items = new Item[]{new Item("Aged Brie", 20, 10)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void quality_never_exceeds_50() {
        final Item[] items = new Item[]{new Item("Aged Brie", 20, 50)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void quality_does_not_increase_by_two_passed_sellIn_date() {
        final Item[] items = new Item[]{new Item("Aged Brie", 0, 30)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
    }
}
