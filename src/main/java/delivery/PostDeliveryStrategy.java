package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public class PostDeliveryStrategy implements Delivery {
    /**
     * return 0 if done successful
     */
    @Override
    public int deliver(LinkedList<Item> items) {
        System.out.println("Delivered " + items + " via Post.");
        return 0;
    }
}