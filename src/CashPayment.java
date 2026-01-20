

public class CashPayment implements Payment {
    public boolean pay(double amount) {
        System.out.println("Cash payment is taken: " + amount + " TL");
        return true;
    }
}