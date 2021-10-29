package store;

import flowerstore.Flower;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorFilterSpecification extends SearchSpecification {
    private int[] color;

    public ColorFilterSpecification(int[] flowerColor) {
        this.color = flowerColor;
    }

    @Override
    protected ArrayList<Flower> applyFilter(ArrayList<Flower> flowers) {
        ArrayList<Flower> filteredFlowers = new ArrayList<>();
        for(Flower flower: flowers) {
            if (Arrays.equals(flower.getColor(), color)) {
                filteredFlowers.add(flower);
            }
        }
        return filteredFlowers;
    }
}
