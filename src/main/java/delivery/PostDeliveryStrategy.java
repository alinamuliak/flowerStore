package delivery;

import flowerstore.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery {
    /**
     * return 0 if done successful
     */
    @Override
    public int deliver(List<Item> items) {
        System.out.println("Delivered " + items + " via Post.");
        return 0;
    }
}