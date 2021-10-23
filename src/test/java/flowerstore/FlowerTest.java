package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower chamomile;
    private Flower rose;
    private Flower tulip;

    @BeforeEach
    void setUp() {
        this.chamomile = new Flower(10, 15, new int[]{0, 1, 2}, FlowerType.CHAMOMILE);
        this.rose = new Flower(5, 8, new int[]{1, 1, 1}, FlowerType.ROSE);
        this.tulip = new Flower(7, 10, new int[]{2, 1, 3}, FlowerType.TULIP);
    }
//
    @Test
    void getPrice() {
        assertEquals(10, chamomile.getPrice());
        assertEquals(5, rose.getPrice());
        assertEquals(7, tulip.getPrice());
    }

    @Test
    void setPrice() {
        chamomile.setPrice(20);
        assertEquals(20, chamomile.getPrice());
        rose.setPrice(10);
        assertEquals(10, rose.getPrice());
    }

    @Test
    void getSepalLength() {
        assertEquals(15, chamomile.getSepalLength());
        assertEquals(8, rose.getSepalLength());
        assertEquals(10, tulip.getSepalLength());
    }

    @Test
    void setSepalLength() {
        tulip.setSepalLength(15);
        assertEquals(15, chamomile.getSepalLength());
        rose.setSepalLength(5);
        assertEquals(5, rose.getSepalLength());
    }

    @Test
    void getColor() {
      assertArrayEquals(new int[]{0, 1, 2}, chamomile.getColor());
      assertArrayEquals(new int[]{1, 1, 1}, rose.getColor());
      assertArrayEquals(new int[]{2, 1, 3}, tulip.getColor());
    }

    @Test
    void setColor() {
        tulip.setColor(new int[]{5, 4, 3});
        assertArrayEquals(new int[]{5, 4, 3}, tulip.getColor());
        chamomile.setColor(new int[]{7, 7, 7});
        assertArrayEquals(new int[]{7, 7, 7}, chamomile.getColor());
        int[] color = new int[] {1, 1, 0};
        rose.setColor(color);
        color[0] = 5;
        assertArrayEquals(new int[] {1, 1, 0}, rose.getColor());
    }

    @Test
    void getFlowerType() {
        assertEquals(FlowerType.CHAMOMILE, chamomile.getFlowerType());
        assertEquals(FlowerType.ROSE, rose.getFlowerType());
        assertEquals(FlowerType.TULIP, tulip.getFlowerType());
    }

    @Test
    void setFlowerType() {
        chamomile.setFlowerType(FlowerType.ROSE);
        assertEquals(FlowerType.ROSE, chamomile.getFlowerType());
    }
}