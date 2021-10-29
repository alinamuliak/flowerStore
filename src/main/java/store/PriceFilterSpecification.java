package store;

import flowerstore.Flower;

import java.util.ArrayList;


public class PriceFilterSpecification extends SearchSpecification {
    private double price;

    public PriceFilterSpecification(double price) {
        this.price = price;
    }

    @Override
    protected ArrayList<Flower> applyFilter(ArrayList<Flower> flowers) {
        ArrayList<Flower> filteredFlowers = new ArrayList<>();
        for(Flower flower: flowers) {
            if (flower.getPrice() == price) {
                filteredFlowers.add(flower);
            }
        }
        return filteredFlowers;
    }
}

