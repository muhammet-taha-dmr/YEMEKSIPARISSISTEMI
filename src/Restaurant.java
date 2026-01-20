import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<MenuItem> menu;

    private int totalRating = 0;
    private int ratingCount = 0;

    public Restaurant(String name) {
        this.name = name;
        menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void showMenu() {
        System.out.println("\n--- Menü ---");
        for (MenuItem item : menu) {
            System.out.println(item.getId() + ". " + item.getName() + " - " + item.getPrice() + " TL");
        }
    }

    public MenuItem getMenuItemById(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // ⭐⭐⭐ PUANLAMA METOTLARI ⭐⭐⭐

    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return (double) totalRating / ratingCount;
    }
}
