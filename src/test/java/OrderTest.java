import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void testTotalWithoutDiscount() {
        Order order = new Order();
        MenuItem item = new MenuItem(1, "Burger", 100);
        order.addItem(item, 2);
        assertEquals(200, order.getTotal());
    }

    @Test
    void testDiscount10() {
        Order order = new Order();
        MenuItem item = new MenuItem(1, "Burger", 100);
        order.addItem(item, 1);
        order.applyDiscount("discount10");
        assertEquals(90, order.getTotal());
    }
}


