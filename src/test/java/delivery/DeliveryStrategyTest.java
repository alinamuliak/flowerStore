package delivery;

import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStrategyTest {
    private Delivery dhlDelivery;
    private Delivery postDelivery;
    private LinkedList<Item> items;


    @BeforeEach
    void setUp() {
        this.dhlDelivery = new DHLDeliveryStrategy();
        this.postDelivery = new PostDeliveryStrategy();
        Flower flower1 = new Flower(10, 10, new int[]{7, 7, 7}, FlowerType.CHAMOMILE);
        Flower flower2 = new Flower(12, 7, new int[]{7, 7, 7}, FlowerType.ROSE);
        this.items = new LinkedList<>(Arrays.asList(flower1, flower2));
    }

    @Test
    void deliver() {
        assertEquals(0, dhlDelivery.deliver(items));
        assertEquals(0, postDelivery.deliver(items));
    }
}