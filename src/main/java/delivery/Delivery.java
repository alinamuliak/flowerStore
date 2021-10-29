package delivery;

import flowerstore.Item;

import java.util.List;

public interface Delivery {
    public void deliver(List<Item> items);
}