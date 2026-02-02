import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DigitalWalletPaymentTest {

    @Test
    void testInsufficientBalance() {
        DigitalWalletPayment balance = new DigitalWalletPayment(2000);
        boolean result = balance.pay(5000);
        assertFalse(result);
    }
}



