package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {
    GildedRose app;

    @Test
    void quality_increases_by_1_as_concert_date_approaches() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void quality_increases_by_2_when_sellIn_is_10_or_less_days() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void quality_increases_by_3_when_sellin_is_5_or_less_days() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void quality_drops_to_0_after_sellIn_date() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_never_goes_above_50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50)};
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
