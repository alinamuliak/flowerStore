package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public class DHLDeliveryStrategy implements Delivery{

    /**
     * return 0 if done successful
     */
    @Override
    public int deliver(LinkedList<Item> items) {
        System.out.println("Delivered " + items + " with DHL.");
        return 0;
    }
}