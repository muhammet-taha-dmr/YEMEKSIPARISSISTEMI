import java.util.Scanner;

public class DigitalWalletPayment implements Payment {

    private double balance = 2000; 

    @Override
    public boolean pay(double amount) {
        Scanner sc = new Scanner(System.in);
        String walletId;

        // ===== WALLET ID =====
        while (true) {
            System.out.print("Please enter your 5-digit digital wallet ID: ");
            walletId = sc.nextLine();

            if (walletId.matches("\\d{5}")) {
                break;
            } else {
                System.out.println("Incorrect entry! Wallet ID must be exactly 5 digits.");
            }
        }

        // ===== BALANCE CHECK =====
        if (balance < amount) {
            System.out.println("Insufficient balance!");
            return false;
        }

        balance -= amount;
        System.out.println("Digital wallet payment successful.");
        System.out.println("Remaining balance: " + balance + " TL");

        return true;
    }
}
