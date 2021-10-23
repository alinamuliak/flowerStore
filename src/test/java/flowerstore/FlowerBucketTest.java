package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    private Flower rose;
    private Flower tulip;
    private Flower chamomile;
    private FlowerPack roses;
    private FlowerPack tulips;
    private FlowerPack chamomiles;
    private FlowerBucket flowerBucket;
    @BeforeEach
    void setUp() {
        this.rose = new Flower(12, 6, new int[]{4, 3, 2}, FlowerType.ROSE);
        this.tulip = new Flower(10, 9, new int[]{5, 5, 7}, FlowerType.TULIP);
        this.chamomile = new Flower(15, 5, new int[]{0, 2, 7}, FlowerType.CHAMOMILE);
        this.roses = new FlowerPack(rose, 3);
        this.tulips = new FlowerPack(tulip, 10);
        this.chamomiles = new FlowerPack(chamomile, 2);
        this.flowerBucket = new FlowerBucket();
    }

    @Test
    void addFlowerPack() {
        flowerBucket.addFlowerPack(roses);
        assertSame(roses, flowerBucket.getFlowerPacks().get(0));
    }

    @Test
    void getPrice() {
        flowerBucket.addFlowerPack(tulips);
        assertEquals(100, flowerBucket.getPrice());
        flowerBucket.addFlowerPack(chamomiles);
        assertEquals(130, flowerBucket.getPrice());
        flowerBucket.addFlowerPack(roses);
        assertEquals(166, flowerBucket.getPrice());
    }

    @Test
    void getFlowerPacks() {
        flowerBucket.addFlowerPack(tulips);
        flowerBucket.addFlowerPack(chamomiles);
        assertSame(tulips, flowerBucket.getFlowerPacks().get(0));
        assertSame(chamomiles, flowerBucket.getFlowerPacks().get(1));
    }
}