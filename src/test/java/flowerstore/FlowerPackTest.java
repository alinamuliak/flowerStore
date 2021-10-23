package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {

    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    void setUp() {
        this.flower = new Flower(10, 15, new int[]{1, 1, 1, 1}, FlowerType.CHAMOMILE);
        this.flowerPack = new FlowerPack(flower, 5);
    }

    @Test
    void getPrice() {
        assertEquals(50, flowerPack.getPrice());
    }

    @Test
    void getFlower() {
        Flower gotten_flower = flowerPack.getFlower();
        assertSame(flower, gotten_flower);
    }

    @Test
    void getAmount() {
        assertEquals(5, flowerPack.getAmount());
    }

    @Test
    void setFlower() {
        Flower flower2 = new Flower(12, 5, new int[]{2, 3, 4}, FlowerType.ROSE);
        flowerPack.setFlower(flower2);
        assertSame(flower2, flowerPack.getFlower());
    }

    @Test
    void setAmount() {
        flowerPack.setAmount(10);
        assertEquals(10, flowerPack.getAmount());
    }
}