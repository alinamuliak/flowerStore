package order;

import delivery.Delivery;
import flowerstore.Item;
import lombok.ToString;
import payment.Payment;

import java.util.LinkedList;

@ToString
public class Order {
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Item item : this.items) {
            price += item.getPrice();
        }
        return price;
    }

    public void processOrder() {
        System.out.println("Your order is being processed...\nDone! Your order is ready!");
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
