package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Disabled
    @Test
    void test1() {
        Item[] items = new Item[] { new Item("foo", 10, 9) };
        GildedRose app = new GildedRose(items);
        nDaysPassed(app,10);
        assertEquals(-1,app.items[0].quality);
    }

    @Test
    void test2(){
        Item[] items = new Item[] { new Item("foo1", 4, 10) };
        GildedRose app = new GildedRose(items);
        nDaysPassed(app,6);
        assertEquals(4,app.items[0].quality);
    }

    @Disabled
    @Test
    void test3(){
        Item[] items = new Item[] { new Item("Aged Brie", 10, 41) };
        GildedRose app = new GildedRose(items);
        nDaysPassed(app,10);
        assertEquals(51,app.items[0].quality);
    }



    private void nDaysPassed(GildedRose app,int days){
        assert days >= 0;
        for (int i=0;i<10;i++)
            app.updateQuality();
    }
}
