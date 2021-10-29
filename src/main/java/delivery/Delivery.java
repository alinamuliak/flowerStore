package delivery;

import flowerstore.Item;

import java.util.List;

public interface Delivery {
    int deliver(List<Item> items);
}