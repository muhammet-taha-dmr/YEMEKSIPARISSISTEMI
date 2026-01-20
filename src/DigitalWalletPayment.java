

public class DigitalWalletPayment implements Payment {
    public boolean pay(double amount) {
        System.out.println("Payment was made by digital wallet: " + amount + " TL");
        return true;
    }
}