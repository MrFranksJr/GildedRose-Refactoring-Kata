package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {
    GildedRose app;

    @BeforeEach
    void setUp() {

    }

    @Test
    void qualityIncreasesAsSellInApproaches() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void qualityIncreasesBy2WhenSellinIsLessThan11Days() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void qualityIncreasesBy3WhenSellinIsLessThan6Days() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    @Test
    void qualityDropsTo0AfterSellinDate() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void qualityNeverGoesAbove50() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
