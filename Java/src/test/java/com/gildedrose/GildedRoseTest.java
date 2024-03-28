package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    GildedRose app;

    @BeforeEach
    void setUp() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        app = new GildedRose(items);
    }

    @Test
    void foo() {
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
