import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ================= USER INFO =================
        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) break;
            System.out.println("❌ Name must contain only letters.");
        }

        String phone;
        while (true) {
            System.out.print("Enter phone number: ");
            phone = sc.nextLine();
            if (phone.matches("\\d+")) break;
            System.out.println("❌ Phone number must contain only digits.");
        }

        String address;
        while (true) {
            System.out.print("Enter address: ");
            address = sc.nextLine();
            if (address.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) break;
            System.out.println("❌ Address must contain only letters.");
        }

        Customer customer = new Customer(1, name, phone, address);

        // ================= RESTAURANTS FROM CSV =================
        Map<Integer, Restaurant> restaurantMap = new HashMap<>();
        restaurantMap.put(1, new Restaurant("Pizza Place"));
        restaurantMap.put(2, new Restaurant("Burger City"));
        restaurantMap.put(3, new Restaurant("Turkish Restaurant"));

        try (BufferedReader br = new BufferedReader(new FileReader("menu.csv"))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");

                int restaurantId = Integer.parseInt(p[0]);
                int itemId = Integer.parseInt(p[1]);
                String itemName = p[2];
                double price = Double.parseDouble(p[3]);

                MenuItem item = new MenuItem(itemId, itemName, price);
                restaurantMap.get(restaurantId).addMenuItem(item);
            }
        } catch (IOException e) {
            System.out.println("menu.csv could not be read!");
            return;
        }

        Restaurant[] restaurants = {
            restaurantMap.get(1),
            restaurantMap.get(2),
            restaurantMap.get(3)
        };

        // ================= ORDER =================
        Order order = new Order();
        Restaurant lastRestaurant = null;
        boolean orderFromAnotherRestaurant = true;

        while (orderFromAnotherRestaurant) {

            // ===== RESTAURANT SELECTION =====
            int choice;
            while (true) {
                System.out.println("\nRestaurants:");
                for (int i = 0; i < restaurants.length; i++) {
                    System.out.println(
                        (i + 1) + ". " +
                        restaurants[i].getName() +
                        " ⭐ " +
                        String.format("%.1f", restaurants[i].getAverageRating())
                    );
                }

                System.out.print("Choose restaurant (1-" + restaurants.length + "): ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice >= 1 && choice <= restaurants.length) break;
                } else {
                    sc.nextLine();
                }
                System.out.println("❌ Invalid restaurant choice.");
            }

            Restaurant selected = restaurants[choice - 1];
            lastRestaurant = selected;

            // ===== ADD ITEMS =====
            boolean addMoreItems = true;
            while (addMoreItems) {

                selected.showMenu();

                int itemId;
                while (true) {
                    System.out.print("Product number: ");
                    if (sc.hasNextInt()) {
                        itemId = sc.nextInt();
                        sc.nextLine();
                        if (selected.getMenuItemById(itemId) != null) break;
                    } else {
                        sc.nextLine();
                    }
                    System.out.println("❌ Invalid product number.");
                }

                int qty;
                while (true) {
                    System.out.print("Quantity: ");
                    if (sc.hasNextInt()) {
                        qty = sc.nextInt();
                        sc.nextLine();
                        if (qty > 0) break;
                    } else {
                        sc.nextLine();
                    }
                    System.out.println("❌ Quantity must be greater than 0.");
                }

                order.addItem(selected.getMenuItemById(itemId), qty);
                System.out.println("✅ Product added.");

                System.out.print("Add another product from this restaurant? (yes/no): ");
                addMoreItems = sc.nextLine().equalsIgnoreCase("yes");
            }

            System.out.print("Order from another restaurant? (yes/no): ");
            orderFromAnotherRestaurant = sc.nextLine().equalsIgnoreCase("yes");
        }

        // ================= DISCOUNT =================
        System.out.print("Enter discount code (or press Enter): ");
        String code = sc.nextLine();
        order.applyDiscount(code);

        System.out.println("\nTotal price: " + order.getTotal() + " TL");

        // ================= PAYMENT =================
        int pay;
        while (true) {
            System.out.println("1- Cash\n2- Credit Card\n3- Digital Wallet");
            System.out.print("Choose payment method: ");

            if (sc.hasNextInt()) {
                pay = sc.nextInt();
                sc.nextLine();
                if (pay >= 1 && pay <= 3) break;
            } else {
                sc.nextLine();
            }
            System.out.println("❌ Invalid payment choice.");
        }

        Payment payment =
                (pay == 1) ? new CashPayment()
              : (pay == 2) ? new CreditCardPayment()
              : new DigitalWalletPayment();

        payment.pay(order.getTotal());

        // ================= RATING =================
        int rating;
        while (true) {
            System.out.print("Rate last restaurant (1-5): ");
            if (sc.hasNextInt()) {
                rating = sc.nextInt();
                sc.nextLine();
                if (rating >= 1 && rating <= 5) break;
            } else {
                sc.nextLine();
            }
            System.out.println("❌ Rating must be between 1 and 5.");
        }

        lastRestaurant.addRating(rating);

        // ===== SHOW UPDATED RATINGS =====
        System.out.println("\nUpdated restaurant ratings:");
        for (int i = 0; i < restaurants.length; i++) {
            System.out.println(
                (i + 1) + ". " +
                restaurants[i].getName() +
                " ⭐ " +
                String.format("%.1f", restaurants[i].getAverageRating())
            );
        }

        System.out.println("\n🎉 Order completed successfully!");
    }
}

    
        

