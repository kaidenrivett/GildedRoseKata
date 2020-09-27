package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {


    // Exercise 4 / 5

    @Test
    void daysPassedequalToSellin() {
        Item[] items = new Item[] { new Item("foo", 10, 9) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        nDaysPassed(app,10);
        assertEquals(0,app.items[0].quality);
    }
    @Test
    void daysPassedgreaterThanSellin() {
        Item[] items = new Item[] { new Item("foo1", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        nDaysPassed(app, 6);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void uniqueItem(){
        Item[] items = new Item[] { new Item("Aged Brie", 10, 41) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        nDaysPassed(app,10);
        assertEquals(50,app.items[0].quality);
    }


    // Exercise1
    @Test
    void sellByDate() {
        // once the sell by date has passed, quality degrades twice as fast
        Item[] items = new Item[] { new Item("Apple", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        nDaysPassed(app,4);
        assertEquals(42,app.items[0].quality);

    }

    // Exercise2
    @Test
    void neverChangeSulfuras() {

        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",99999,80)};
        GildedRose app = new GildedRose(items);
        nDaysPassed(app, 999);
        assertEquals(80, app.items[0].quality);
        System.out.println(app.items[0].quality);

    }

    // Exercise3
    @Test
    void backstagePass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",13,29)};
        GildedRose app = new GildedRose(items);
        nDaysPassed(app, 12);
        System.out.println("The quality value of Backstage Passes after 12 days have passed is: " + app.items[0].quality);
    }


    private void nDaysPassed(GildedRose app, int days){
        assert days >= 0;
        for (int i=0; i<days; i++)
            app.updateQuality();
    }
}
