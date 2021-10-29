package order;

import delivery.DHLDeliveryStrategy;
import delivery.Delivery;
import delivery.PostDeliveryStrategy;
import flowerstore.Flower;
import flowerstore.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;
import payment.Payment;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order1;
    private Order order2;
    private Order order3;

    private Flower flower1;
    private Flower flower2;
    private Flower flower3;

    @BeforeEach
    void setUp() {
        this.order1 = new Order();
        this.order2 = new Order();
        this.order3 = new Order();

        this.flower1 = new Flower(20, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);
        this.flower2 = new Flower(25, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);
        this.flower3 = new Flower(15, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);

    }

    @Test
    void setPaymentStrategy() {
        Payment creditCard = new CreditCardPaymentStrategy();
        Payment payPal = new PayPalPaymentStrategy();
        this.order1.setPaymentStrategy(creditCard);
        this.order2.setPaymentStrategy(payPal);
        this.order3.setPaymentStrategy(payPal);

        assertSame(creditCard, this.order1.getPayment());
        assertSame(payPal, this.order2.getPayment());
        assertSame(payPal, this.order3.getPayment());
    }

    @Test
    void setDeliveryStrategy() {
        Delivery dhl = new DHLDeliveryStrategy();
        Delivery post = new PostDeliveryStrategy();
        this.order1.setDeliveryStrategy(post);
        this.order2.setDeliveryStrategy(post);
        this.order3.setDeliveryStrategy(dhl);

        assertSame(post, this.order1.getDelivery());
        assertSame(post, this.order2.getDelivery());
        assertSame(dhl, this.order3.getDelivery());
    }

    @Test
    void addItem() {
        this.order1.addItem(this.flower1);
        this.order1.addItem(this.flower2);
        this.order2.addItem(this.flower2);
        this.order2.addItem(this.flower3);
        this.order3.addItem(this.flower1);
        this.order3.addItem(this.flower3);

        assertArrayEquals(new Flower[]{flower1, flower2}, this.order1.getItems().toArray());
        assertArrayEquals(new Flower[]{flower2, flower3}, this.order2.getItems().toArray());
        assertArrayEquals(new Flower[]{flower1, flower3}, this.order3.getItems().toArray());
    }

    @Test
    void calculateTotalPrice() {
        this.order1.addItem(this.flower1);
        this.order1.addItem(this.flower2);
        this.order2.addItem(this.flower2);
        this.order2.addItem(this.flower3);
        this.order3.addItem(this.flower1);
        this.order3.addItem(this.flower3);

        assertEquals(45, this.order1.calculateTotalPrice());
        assertEquals(40, this.order2.calculateTotalPrice());
        assertEquals(35, this.order3.calculateTotalPrice());
    }

    @Test
    void processOrder() {
        assertEquals(0, this.order1.processOrder());
        assertEquals(0, this.order2.processOrder());
        assertEquals(0, this.order3.processOrder());
    }

    @Test
    void removeItem() {
        this.order1.addItem(this.flower1);
        this.order1.addItem(this.flower2);
        this.order1.removeItem(this.flower1);

        this.order2.addItem(this.flower2);
        this.order2.addItem(this.flower3);
        this.order2.removeItem(this.flower2);

        this.order3.addItem(this.flower1);
        this.order3.addItem(this.flower3);
        this.order3.removeItem(this.flower3);

        assertArrayEquals(new Flower[]{this.flower2}, this.order1.getItems().toArray());
        assertArrayEquals(new Flower[]{this.flower3}, this.order2.getItems().toArray());
        assertArrayEquals(new Flower[]{this.flower1}, this.order3.getItems().toArray());
    }
}