package payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Payment creditCard;
    private Payment payPal;

    @BeforeEach
    void setUp() {
        this.creditCard = new CreditCardPaymentStrategy();
        this.payPal = new PayPalPaymentStrategy();
    }

    @Test
    void pay() {
        assertEquals(0, creditCard.pay(100));
        assertEquals(0, payPal.pay(250));
    }
}