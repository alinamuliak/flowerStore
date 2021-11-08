package decorators;

import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDecoratorTest {

    private Item flower1;
    private Item flower2;
    private Item flower3;

    @BeforeEach
    void setUp() {
        this.flower1 = new Flower(100, 20, new int[]{1, 6, 4, 2, 7, 9, 0}, FlowerType.TULIP);
        this.flower2 = new Flower(250, 20, new int[]{0, 0, 0, 0, 0, 0, 0}, FlowerType.ROSE);
        this.flower3 = new Flower(15, 20, new int[]{7, 7, 7, 7, 7, 7, 7}, FlowerType.CHAMOMILE);
    }

    @Test
    void getPricePaperDecorator() {
        PaperDecorator paper1 = new PaperDecorator(flower1);
        PaperDecorator paper2 = new PaperDecorator(flower2);
        PaperDecorator paper3 = new PaperDecorator(flower3);

        assertEquals(113, paper1.getPrice());
        assertEquals(263, paper2.getPrice());
        assertEquals(28, paper3.getPrice());
    }

    @Test
    void getPriceBasketDecorator() {
        BasketDecorator basketDecorator1 = new BasketDecorator(flower1);
        BasketDecorator basketDecorator2 = new BasketDecorator(flower2);
        BasketDecorator basketDecorator3 = new BasketDecorator(flower3);

        assertEquals(104, basketDecorator1.getPrice());
        assertEquals(254, basketDecorator2.getPrice());
        assertEquals(19, basketDecorator3.getPrice());
    }

    @Test
    void getPriceRibbonDecorator() {
        RibbonDecorator ribbon1 = new RibbonDecorator(flower1);
        RibbonDecorator ribbon2 = new RibbonDecorator(flower2);
        RibbonDecorator ribbon3 = new RibbonDecorator(flower3);

        assertEquals(140, ribbon1.getPrice());
        assertEquals(290, ribbon2.getPrice());
        assertEquals(55, ribbon3.getPrice());
    }

    @Test
    void getPriceValentineDecorator() {
        ValentineDecorator valentine1 = new ValentineDecorator(flower1);
        ValentineDecorator valentine2 = new ValentineDecorator(flower2);
        ValentineDecorator valentine3 = new ValentineDecorator(flower3);

        assertEquals(70, valentine1.getPrice());
        assertEquals(175, valentine2.getPrice());
        assertEquals(10.5, valentine3.getPrice());
    }
}