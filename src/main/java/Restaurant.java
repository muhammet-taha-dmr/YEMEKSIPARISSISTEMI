import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<MenuItem> menuItems;
    private List<Integer> ratings;

    public Restaurant(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    // MENU
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void showMenu() {
        System.out.println("\nMenu - " + name);
        for (MenuItem item : menuItems) {
            System.out.println(
                item.getId() + ". " +
                item.getName() + " - " +
                item.getPrice() + " TL"
            );
        }
    }

    public MenuItem getMenuItemById(int id) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // RATING
    public void addRating(int rating) {
        ratings.add(rating);
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        return (double) sum / ratings.size();
    }

    public String getName() {
        return name;
    }
}

