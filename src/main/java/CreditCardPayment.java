import java.util.Scanner;

public class CreditCardPayment implements Payment {

    @Override
    public boolean pay(double amount) {
        Scanner sc = new Scanner(System.in);
        String cardNumber;

        while (true) {
            System.out.print("Please enter your 16-digit credit card number: ");
            cardNumber = sc.nextLine();

            if (cardNumber.matches("\\d{16}")) {
                break;
            } else {
                System.out.println("Incorrect entry! Credit card number must be exactly 16 digits.");
            }
        }

        System.out.println("Credit card payment successful.");
        System.out.println("Paid amount: " + amount + " TL");
        return true;
    }
}

