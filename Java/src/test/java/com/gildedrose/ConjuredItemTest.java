package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    GildedRose app;

    @Test
    void quality_decreases_with_2_every_day() {
        final Item item = new Item("Conjured", 20, 10);
        app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void can_handle_any_conjured_item_type() {
        final Item item = new Item("Conjured potion", 20, 10);
        app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void quality_decreases_with_4_past_sellIn_date() {
        final Item item = new Item("Conjured", 0, 10);
        app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void quality_does_not_dip_below_zero() {
        final Item item = new Item("Conjured", 5, 1);
        app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_does_not_dip_below_zero_even_when_expired() {
        final Item item = new Item("Conjured", 0, 3);
        app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
