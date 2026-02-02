package com.yemek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yemek.MenuItem;

public class MenuItemTest {

    @Test
    void testMenuItemPrice() {
        MenuItem item = new MenuItem(1, "Pizza", 120);
        assertEquals(120, item.getPrice());
    }
}
