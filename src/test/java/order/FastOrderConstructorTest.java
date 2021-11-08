package order;

import delivery.PostDeliveryStrategy;
import flowerstore.Flower;
import flowerstore.FlowerBucket;
import flowerstore.FlowerPack;
import flowerstore.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class FastOrderConstructorTest {

    private FastOrderConstructor tulips;
    private FastOrderConstructor roses;
    private FastOrderConstructor chamomiles;

    @BeforeEach
    void setUp() {
        tulips = FastOrderConstructor.TULIP_BUCKET;
        roses = FastOrderConstructor.ROSE_BUCKET;
        chamomiles = FastOrderConstructor.CHAMOMILE_BUCKET;
    }

    @Test
    void createOrder() {
        FlowerBucket flower_bucket = new FlowerBucket();
        FlowerBucket flower_bucket1 = new FlowerBucket();
        FlowerBucket flower_bucket2 = new FlowerBucket();

        Order order = FastOrderConstructor.createOrder(roses, 10);
        assertEquals(220, order.calculateTotalPrice());
        assertEquals(PostDeliveryStrategy.class, order.getDelivery().getClass());
        assertEquals(PayPalPaymentStrategy.class, order.getPayment().getClass());
        FlowerPack pack = new FlowerPack(roses.getFlower(), 10);
        flower_bucket.addFlowerPack(pack);
        assertEquals(flower_bucket.toString(), order.getItems().get(0).toString());

        order = FastOrderConstructor.createOrder(tulips, 15);
        assertEquals(255, order.calculateTotalPrice());
        assertEquals(PostDeliveryStrategy.class, order.getDelivery().getClass());
        assertEquals(PayPalPaymentStrategy.class, order.getPayment().getClass());
        FlowerPack pack1 = new FlowerPack(tulips.getFlower(), 15);
        flower_bucket1.addFlowerPack(pack1);
        assertEquals(flower_bucket1.toString(), order.getItems().get(0).toString());

        order = FastOrderConstructor.createOrder(chamomiles, 20);
        assertEquals(300, order.calculateTotalPrice());
        assertEquals(PostDeliveryStrategy.class, order.getDelivery().getClass());
        assertEquals(PayPalPaymentStrategy.class, order.getPayment().getClass());
        FlowerPack pack2 = new FlowerPack(chamomiles.getFlower(), 20);
        flower_bucket2.addFlowerPack(pack2);
        assertEquals(flower_bucket2.toString(), order.getItems().get(0).toString());
    }

    @Test
    void getFlower() {
        assertEquals(new Flower(17, 15, new int[] {7, 7, 7}, FlowerType.TULIP).toString(), tulips.getFlower().toString());
        assertEquals(new Flower(22, 10, new int[] {1, 2, 3}, FlowerType.ROSE).toString(), roses.getFlower().toString());
        assertEquals(new Flower(15, 5, new int[] {2, 2, 5}, FlowerType.CHAMOMILE).toString(), chamomiles.getFlower().toString());
    }
}