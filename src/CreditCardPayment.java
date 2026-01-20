

public class CreditCardPayment implements Payment {
    public boolean pay(double amount) {
        System.out.println("Payment was made by credit card: " + amount + " TL");
        return true;
    }
}