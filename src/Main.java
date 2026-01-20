import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ====== NAME ======
        String name;
        while (true) {
            System.out.print("Please enter your name: ");
            name = sc.nextLine();
            if (name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                break;
            } else {
                System.out.println("Incorrect entry!! The name must consist only of letters.");
            }
        }

        // ====== PHONE ======
        String phone;
        while (true) {
            System.out.print("Please enter your phone number: ");
            phone = sc.nextLine();
            if (phone.matches("\\d+")) {
                break;
            } else {
                System.out.println("Incorrect entry! The phone number should consist only of numbers.");
            }
        }

        // ====== ADRESS ======
        String address;
        while (true) {
            System.out.print("Please enter your adress: ");
            address = sc.nextLine();
            if (address.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                break;
            } else {
                System.out.println("Incorrect entry! The address cannot contain numbers.");
            }
        }

        Customer customer = new Customer(1, name, phone, address);

        // ====== RESTAURANTS ======
        Restaurant r1 = new Restaurant("Sultan's Pizza ");
        r1.addMenuItem(new MenuItem(1, "Mixed Pizza: mushroom, cheddar, tomatoes, sausage", 120));
        r1.addMenuItem(new MenuItem(2, "Margarita: mozzarella, basil leaves, tomatoes ", 90));
        r1.addMenuItem(new MenuItem(3, "Turkish speciale: meat, cheese, spice ", 110));
        

        Restaurant r2 = new Restaurant("Burger City");
        r2.addMenuItem(new MenuItem(1, "Classic Burger", 180));
        r2.addMenuItem(new MenuItem(2, "Chips", 40));
        r2.addMenuItem(new MenuItem(3, "Cheeseburger", 200));
        r2.addMenuItem(new MenuItem(4, "Onion Ring", 90));

        Restaurant r3 = new Restaurant("Turkish Restaurant");
        r3.addMenuItem(new MenuItem(1, "Kebab ", 250));
        r3.addMenuItem(new MenuItem(2, "Chicken and Rice", 130));
        r3.addMenuItem(new MenuItem(3, "Sarma", 90));
        r3.addMenuItem(new MenuItem(4, "Kunefe", 100));

        Restaurant[] restaurants = { r1, r2, r3 };

        // ====== RESTAURANT CHOICE ======
        int choice;
        while (true) {
            System.out.println("\nRestaurants:");
            for (int i = 0; i < restaurants.length; i++) {
                System.out.println(
                    (i + 1) + ". " +
                    restaurants[i].getName() + 
                    " ⭐️ " +
                    String.format("%1f", restaurants[i].getAverageRating())
                );
            }

            System.out.print("Please choose a restaurant (1-3): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Incorrect entry! Please select 1-3.");
                }
            } else {
                System.out.println("Incorrect input! Please enter a number.");
                sc.nextLine();
            }
        }

        Restaurant selected = restaurants[choice - 1];
        Order order = new Order();

        // ====== ADD AN ITEM ======
        boolean devam = true;

        while (devam) {
            selected.showMenu();

            int itemId;
            while (true) {
                System.out.print("Product number: ");
                if (sc.hasNextInt()) {
                    itemId = sc.nextInt();
                    sc.nextLine();
                    if (selected.getMenuItemById(itemId) != null) {
                        break;
                    } else {
                        System.out.println("Incorrect entry! This product does not exist.");
                    }
                } else {
                    System.out.println("Incorrect input! Please enter a number.");
                    sc.nextLine();
                }
            }

            int qty;
            while (true) {
                System.out.print("Quantity: ");
                if (sc.hasNextInt()) {
                    qty = sc.nextInt();
                    sc.nextLine();
                    if (qty > 0) {
                        break;
                    } else {
                        System.out.println("Incorrect entry! The quantity must be greater than 0.");
                    }
                } else {
                    System.out.println("Incorrect input! Please enter a number.");
                    sc.nextLine();
                }
            }

            order.addItem(selected.getMenuItemById(itemId), qty);
            System.out.println("Product added to cart ✅");

            while (true) {
                System.out.print("Would you like to add any other products? (yes/no): ");
                String cevap = sc.nextLine();
                if (cevap.equalsIgnoreCase("yes")) {
                    break;
                } else if (cevap.equalsIgnoreCase("no")) {
                    devam = false;
                    break;
                } else {
                    System.out.println("Incorrect entry! Please enter only yes or no.");
                }
            }
        }
        System.out.print("Enter your discount code (leave it blank if you don't have one): ");
        String discountCode = sc.nextLine();
        order.applyDiscount(discountCode);
 

        // ====== TOTAL ======
        System.out.println("\nTotal price: " + order.getTotal() + " TL");

        // ====== PAYMENT ======
        int payChoice;
        while (true) {
            System.out.println("Payment method:");
            System.out.println("1- Cash");
            System.out.println("2- With Credit Card");
            System.out.println("3- With Digital Wallet");

            if (sc.hasNextInt()) {
                payChoice = sc.nextInt();
                sc.nextLine();
                if (payChoice >= 1 && payChoice <= 3) {
                    break;
                } else {
                    System.out.println("Incorrect input! Please select 1-3.");
                }
            } else {
                System.out.println("Incorrect input! Please enter a number.");
                sc.nextLine();
            }
        }

        Payment payment;
        if (payChoice == 1) {
            payment = new CashPayment();
        } else if (payChoice == 2) {
            payment = new CreditCardPayment();
        } else {
            payment = new DigitalWalletPayment();
        }

        payment.pay(order.getTotal());

        // ====== RATİNG ======
        int rating;
        while (true) {
            System.out.print("Please rate the restaurant on a scale of 1-5: ");
            if (sc.hasNextInt()) {
                rating = sc.nextInt();
                sc.nextLine();
                selected.addRating(rating);
                if (rating >= 1 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Incorrect entry! Please enter a rating between 1 and 5.");
                }
            } else {
                System.out.println("Incorrect input! Please enter a number.");
                sc.nextLine();
            }
        }

        System.out.println("Thank you! Your rating: " + rating + "/5 ⭐️");
        System.out.println("Order completed successfully!! ");
    }
}