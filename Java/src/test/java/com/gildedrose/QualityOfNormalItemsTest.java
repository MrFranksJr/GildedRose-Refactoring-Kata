package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityOfNormalItemsTest {
    GildedRose app;

    @BeforeEach
    void setUp() {

    }

    @Test
    void quality_decreases_with_1_every_day() {
        Item[] items = new Item[] {new Item("normalItem", 20, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("normalItem", app.items[0].name);
        assertEquals(19, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void quality_decreases_with_2_when_past_sell_by_date() {
        Item[] items = new Item[] {new Item("normalItem", 0, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("normalItem", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void quality_never_goes_below_0() {
        Item[] items = new Item[] {new Item("normalItem", 10, 0) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("normalItem", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
