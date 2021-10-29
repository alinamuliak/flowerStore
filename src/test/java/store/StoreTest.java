package store;

import flowerstore.Flower;
import flowerstore.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private Flower flower1;
    private Flower flower2;
    private Flower flower3;
    private Flower flower4;
    private Flower flower5;
    private ArrayList<Flower> flowers;
    private Store store;


    @BeforeEach
    void setUp() {
        flower1 = new Flower(10, 13, new int[] {7, 7, 7}, FlowerType.ROSE);
        flower2 = new Flower(10, 12, new int[] {1, 2, 3}, FlowerType.TULIP);
        flower3 = new Flower(15, 5, new int[] {7, 7, 7}, FlowerType.TULIP);
        flower4 = new Flower(13, 12, new int[] {7, 7, 7}, FlowerType.CHAMOMILE);
        flower5 = new Flower(16, 17, new int[] {1, 2, 0}, FlowerType.CHAMOMILE);
        flowers = new ArrayList<>(Arrays.asList(flower1, flower2, flower3, flower4, flower5));
        store = new Store();
    }

    @Test
    void search() {
//        by price
        PriceFilterSpecification price = new PriceFilterSpecification(10);
        ArrayList<Flower> filteredFlowers = store.search(flowers, price);
        assertTrue(filteredFlowers.contains(flower1));
        assertTrue(filteredFlowers.contains(flower2));
        assertEquals(2, filteredFlowers.size());

//        by color
        ColorFilterSpecification color = new ColorFilterSpecification(new int[]{7, 7, 7});
        filteredFlowers = store.search(flowers, color);
        assertTrue(filteredFlowers.contains(flower1));
        assertTrue(filteredFlowers.contains(flower3));
        assertTrue(filteredFlowers.contains(flower4));
        assertEquals(3, filteredFlowers.size());

//        by sepalLength
        SepalLengthFilterSpecification sepalLength = new SepalLengthFilterSpecification(12);
        filteredFlowers = store.search(flowers, sepalLength);
        assertTrue(filteredFlowers.contains(flower2));
        assertTrue(filteredFlowers.contains(flower4));
        assertEquals(2, filteredFlowers.size());

//        by flowertype
        FlowerTypeFilterSpecification flowerType = new FlowerTypeFilterSpecification(FlowerType.CHAMOMILE);
        filteredFlowers = store.search(flowers, flowerType);
        assertTrue(filteredFlowers.contains(flower4));
        assertTrue(filteredFlowers.contains(flower5));
        assertEquals(2, filteredFlowers.size());
    }
}