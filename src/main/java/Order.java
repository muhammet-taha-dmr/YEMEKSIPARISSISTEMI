

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private double discountRate = 0;

    public static void main(String[] args) {
        
    }
    public Order() {
        items = new ArrayList<>();
        discountRate = 0;
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(new OrderItem(item, quantity));
    }

    public void applyDiscount(String code) {
        if (code.equalsIgnoreCase("Discount10")) {
            discountRate = 0.10;
            System.out.println("10% discount applied!");
        }else if (!code.isEmpty()) {System.out.println("Invalid discount code.");
    }
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total * (1 - discountRate);
    }

    public void printOrder() {
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total " + getTotal() + " TL");
    }
}