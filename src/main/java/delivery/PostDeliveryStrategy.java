package delivery;

import flowerstore.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public void deliver(List<Item> items) {
        System.out.println("Delivered " + items + " via Post.");
    }
}