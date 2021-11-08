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
import user.Receiver;
import user.Sender;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order1;
    private Order order2;
    private Order order3;

    private Flower flower1;
    private Flower flower2;
    private Flower flower3;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        this.order1 = new Order();
        this.order2 = new Order();
        this.order3 = new Order();

        this.flower1 = new Flower(20, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);
        this.flower2 = new Flower(25, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);
        this.flower3 = new Flower(15, 5, new int[]{1, 2, 3, 4}, FlowerType.CHAMOMILE);

        this.user1 = new Sender();
        this.user2 = new Receiver();
    }

    @Test
    void setPaymentStrategy() {
        Payment creditCard = new CreditCardPaymentStrategy();
        Payment payPal = new PayPalPaymentStrategy();
        order1.setPaymentStrategy(creditCard);
        order2.setPaymentStrategy(payPal);
        order3.setPaymentStrategy(payPal);

        assertSame(creditCard, order1.getPayment());
        assertSame(payPal, order2.getPayment());
        assertSame(payPal, order3.getPayment());
    }

    @Test
    void setDeliveryStrategy() {
        Delivery dhl = new DHLDeliveryStrategy();
        Delivery post = new PostDeliveryStrategy();
        order1.setDeliveryStrategy(post);
        order2.setDeliveryStrategy(post);
        order3.setDeliveryStrategy(dhl);

        assertSame(post, order1.getDelivery());
        assertSame(post, order2.getDelivery());
        assertSame(dhl, order3.getDelivery());
    }

    @Test
    void addItem() {
        order1.addItem(flower1);
        order1.addItem(flower2);
        order2.addItem(flower2);
        order2.addItem(flower3);
        order3.addItem(flower1);
        order3.addItem(flower3);

        assertArrayEquals(new Flower[]{flower1, flower2}, order1.getItems().toArray());
        assertArrayEquals(new Flower[]{flower2, flower3}, order2.getItems().toArray());
        assertArrayEquals(new Flower[]{flower1, flower3}, order3.getItems().toArray());
    }

    @Test
    void calculateTotalPrice() {
        order1.addItem(flower1);
        order1.addItem(flower2);
        order2.addItem(flower2);
        order2.addItem(flower3);
        order3.addItem(flower1);
        order3.addItem(flower3);

        assertEquals(45, order1.calculateTotalPrice());
        assertEquals(40, order2.calculateTotalPrice());
        assertEquals(35, order3.calculateTotalPrice());
    }

    @Test
    void processOrder() {
        assertEquals(0, order1.processOrder());
        assertEquals(0, order2.processOrder());
        assertEquals(0, order3.processOrder());
    }

    @Test
    void removeItem() {
        order1.addItem(flower1);
        order1.addItem(flower2);
        order1.removeItem(flower1);

        order2.addItem(flower2);
        order2.addItem(flower3);
        order2.removeItem(flower2);

        order3.addItem(flower1);
        order3.addItem(flower3);
        order3.removeItem(flower3);

        assertArrayEquals(new Flower[]{flower2}, order1.getItems().toArray());
        assertArrayEquals(new Flower[]{flower3}, order2.getItems().toArray());
        assertArrayEquals(new Flower[]{flower1}, order3.getItems().toArray());
    }

    @Test
    void addUser() {
        order1.addUser(user1);
        order1.addUser(user2);
        assertArrayEquals(new User[]{user1, user2}, order1.getUsers().toArray());
    }

    @Test
    void removeUser() {
        order1.addUser(user1);
        order1.addUser(user2);
        assertArrayEquals(new User[]{user1, user2}, this.order1.getUsers().toArray());

        order1.removeUser(user1);
        assertArrayEquals(new User[]{user2}, this.order1.getUsers().toArray());
    }

    @Test
    void order() {
        assertEquals(0, order1.order());
        assertEquals(0, order2.order());
        assertEquals(0, order3.order());
    }
}