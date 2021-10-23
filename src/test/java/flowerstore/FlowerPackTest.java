package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {

    private Flower flower1;
    private Flower flower2;
    private Flower flower3;
    private Flower flower4;

    @BeforeEach
    void setUp() {
        this.flower1 = new Flower(10, 15, new int[]{1, 1, 1, 1}, FlowerType.CHAMOMILE);
    }

    @Test
    void getPrice() {
    }

    @Test
    void getFlower() {
    }

    @Test
    void getAmount() {
    }

    @Test
    void setFlower() {
    }

    @Test
    void setAmount() {
    }
}