package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityOfSulfurasTest {
    GildedRose app;

    @BeforeEach
    void setUp() {

    }

    @Test
    void qualityAndSellinDateNeverChange() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 20, 80) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(20, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
}
