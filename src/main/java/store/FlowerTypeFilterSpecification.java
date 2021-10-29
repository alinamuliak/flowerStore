package store;

import flowerstore.Flower;
import flowerstore.FlowerType;

import java.util.ArrayList;


public class FlowerTypeFilterSpecification extends SearchSpecification {
    private FlowerType flowerType;

    public FlowerTypeFilterSpecification(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    @Override
    protected ArrayList<Flower> applyFilter(ArrayList<Flower> flowers) {
        ArrayList<Flower> filteredFlowers = new ArrayList<>();
        for(Flower flower: flowers) {
            if (flower.getFlowerType() == flowerType) {
                filteredFlowers.add(flower);
            }
        }
        return filteredFlowers;
    }
}

