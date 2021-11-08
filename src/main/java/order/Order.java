package order;

import delivery.Delivery;
import flowerstore.Item;
import lombok.Getter;
import lombok.ToString;
import payment.Payment;
import user.User;

import java.util.LinkedList;
import java.util.List;

@Getter @ToString
public class Order {
    private List<User> users = new LinkedList<>();
    private LinkedList<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;
    private int currentId = 0;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public int processOrder() {
        System.out.println("Your order is being processed...\nDone! Your order is ready!");
        return 0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addUser(User user) {
        currentId++;
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public int notifyUsers(String status) {
        for (User user: users) {
            user.update(status);
        }
        return 0;
    }

    public int order() {
        return notifyUsers("Your order is ready!");
    }
}
