package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public interface Delivery {
    int deliver(LinkedList<Item> items);
}