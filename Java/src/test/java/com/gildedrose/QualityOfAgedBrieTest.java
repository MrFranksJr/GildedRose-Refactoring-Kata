package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityOfAgedBrieTest {
    GildedRose app;

    @BeforeEach
    void setUp() {

    }

    @Test
    void qualityIncreasesWhenGettingOlder() {
        final Item[] items = new Item[] {new Item("Aged Brie", 20, 10) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void qualityNeverExceeds50() {
        final Item[] items = new Item[] {new Item("Aged Brie", 20, 50) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    //TODO: fix this bug
    @Test
    @Disabled
    void qualityDoesNotIncreaseBy2PastSellInDate() {
        final Item[] items = new Item[] {new Item("Aged Brie", 0, 30) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }
}
